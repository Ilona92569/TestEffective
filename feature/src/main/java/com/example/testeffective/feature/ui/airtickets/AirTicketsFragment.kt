package com.example.testeffective.feature.ui.airtickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testeffective.data.sharedpreference.PrefsManager
import com.example.testeffective.feature.ui.airtickets.adapter.TravelOfferAdapter
import com.example.testeffective.feature.databinding.FragmentAirTicketsBinding
import com.example.testeffective.feature.extensions.addHorizontalGaps
import com.example.testeffective.feature.extensions.filterForCyrillic
import com.example.testeffective.feature.ui.bottomsheets.ChoiceCityBottomSheets
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AirTicketsFragment : Fragment() {

    private var _binding: FragmentAirTicketsBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel by viewModel<AirTicketsViewModel>()

    private lateinit var adapterTravelOffers: TravelOfferAdapter

    private val prefsManager by lazy {
        PrefsManager(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentAirTicketsBinding.inflate(inflater, container, false)
            .also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val bottomSheetChoiceCity = ChoiceCityBottomSheets(requireContext(), layoutInflater)

            if (!prefsManager.cityFrom.isNullOrEmpty()) editTextCityFrom.setText(prefsManager.cityFrom)

            editTextCityFrom.filterForCyrillic()

            adapterTravelOffers = TravelOfferAdapter(requireContext())

            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                viewModel.getTravelOffers()
            }
            viewModel.listTravelOffers.observe(viewLifecycleOwner) {
                adapterTravelOffers.submitList(it.offers)
            }

            listTravelOffer.addHorizontalGaps()
            listTravelOffer.adapter = adapterTravelOffers
            listTravelOffer.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            editTextCityTo.setOnClickListener {
                prefsManager.cityFrom = editTextCityFrom.text.toString()
                bottomSheetChoiceCity.showMenuBottomSheet(
                    editTextCityFrom.text.toString(), viewLifecycleOwner,
                    goToBlankScreen =
                    {
                        findNavController().navigate(AirTicketsFragmentDirections.actionAirTicketsFragmentToStubFragment5())
                    },
                    goToNextFragment =
                    { cityFrom, cityTo ->
                        findNavController().navigate(
                            AirTicketsFragmentDirections.actionAirTicketsFragmentToCountrySelectedFragment(
                                cityFrom,
                                cityTo
                            )
                        )
                    })
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}