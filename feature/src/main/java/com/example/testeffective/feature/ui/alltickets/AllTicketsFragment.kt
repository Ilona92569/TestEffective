package com.example.testeffective.feature.ui.alltickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testeffective.feature.R
import com.example.testeffective.feature.databinding.FragmentAllTicketsBinding
import com.example.testeffective.feature.extensions.addVerticalGaps
import com.example.testeffective.feature.ui.alltickets.adapter.InfoTicketAdapter
import com.example.testeffective.feature.ui.countryselected.CountrySelectedFragmentArgs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllTicketsFragment : Fragment() {

    private var _binding: FragmentAllTicketsBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel by viewModel<AllTicketsViewModel>()
    private val args: AllTicketsFragmentArgs by navArgs()

    private lateinit var adapterInfoTicket: InfoTicketAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentAllTicketsBinding.inflate(inflater, container, false)
            .also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            textPath.text = getString(R.string.path, args.CITYFROM, args.CITYTO)
            textInfoAboutFlight.text = getString(R.string.info_about_flight, args.DATE)

            adapterInfoTicket = InfoTicketAdapter(requireContext())

            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                viewModel.getAllTickets()
            }
            viewModel.listAllTickets.observe(viewLifecycleOwner) {
                adapterInfoTicket.submitList(it.tickets)
            }

            listAllTickets.addVerticalGaps()
            listAllTickets.adapter = adapterInfoTicket
            listAllTickets.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            iconBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}