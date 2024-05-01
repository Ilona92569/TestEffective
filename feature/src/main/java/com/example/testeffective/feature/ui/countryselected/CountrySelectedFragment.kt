package com.example.testeffective.feature.ui.countryselected

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testeffective.feature.R
import com.example.testeffective.feature.databinding.FragmentCountrySelectedBinding
import com.example.testeffective.feature.extensions.addVerticalGaps
import com.example.testeffective.feature.extensions.filterForCyrillic
import com.example.testeffective.feature.ui.countryselected.adapter.StraightFlightsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Calendar

class CountrySelectedFragment : Fragment() {

    private var _binding: FragmentCountrySelectedBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val args: CountrySelectedFragmentArgs by navArgs()

    private val viewModel by viewModel<CountrySelectedViewModel>()

    private lateinit var adapterStraightFlight: StraightFlightsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentCountrySelectedBinding.inflate(inflater, container, false)
            .also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            editTextCityFrom.setText(args.CITYFROM)
            editTextCityTo.setText(args.CITYTO)

            editTextCityFrom.filterForCyrillic()
            editTextCityTo.filterForCyrillic()

            val drawableStartPlus =
                ResourcesCompat.getDrawable(resources, R.drawable.icon_plus, null)
            buttonAddBackTicket.setCompoundDrawablesRelativeWithIntrinsicBounds(
                drawableStartPlus,
                null,
                null,
                null
            )

            val drawableStartPeople =
                ResourcesCompat.getDrawable(resources, R.drawable.icon_people, null)
            buttonPeople.setCompoundDrawablesRelativeWithIntrinsicBounds(
                drawableStartPeople,
                null,
                null,
                null
            )

            val drawableStartFilter =
                ResourcesCompat.getDrawable(resources, R.drawable.icon_filter, null)
            buttonFilter.setCompoundDrawablesRelativeWithIntrinsicBounds(
                drawableStartFilter,
                null,
                null,
                null
            )


            val calendar = Calendar.getInstance()
            val monthNow = calendar.get(Calendar.MONTH)
            val dayNow = calendar.get(Calendar.DAY_OF_MONTH)
            val textDateNow = requireContext().getString(
                R.string.string_date,
                dayNow,
                monthsConversion((monthNow + 1).toString()),
                "сб"
            )
            var date = getString(
                R.string.departure_date,
                dayNow,
                fullMonthsConversion((monthNow + 1).toString())
            )
            buttonDate.text = textDateNow

            adapterStraightFlight = StraightFlightsAdapter(requireContext())

            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                viewModel.getStraightFlights()
            }
            viewModel.listStraightFlights.observe(viewLifecycleOwner) {
                adapterStraightFlight.submitList(it.tickets_offers)
            }

            listStraightFlight.addVerticalGaps()
            listStraightFlight.adapter = adapterStraightFlight
            listStraightFlight.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            iconChangeCity.setOnClickListener {
                val cityFrom = editTextCityFrom.text.toString()
                editTextCityFrom.setText(editTextCityTo.text.toString())
                editTextCityTo.setText(cityFrom)
            }

            iconClose.setOnClickListener {
                editTextCityTo.setText("")
            }

            iconBack.setOnClickListener {
                findNavController().popBackStack()
            }

            buttonDate.setOnClickListener {
                val c = Calendar.getInstance()
                val yearNow = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val dpd =
                    DatePickerDialog(requireContext(), { _, year, monthOfYear, dayOfMonth ->
                        val textDate = requireContext().getString(
                            R.string.string_date,
                            dayOfMonth,
                            monthsConversion((monthOfYear + 1).toString()),
                            "сб"
                        )
                        date = getString(
                            R.string.departure_date,
                            dayNow,
                            fullMonthsConversion((monthOfYear + 1).toString())
                        )
                        buttonDate.text = textDate
                    }, yearNow, month, day)
                dpd.datePicker.minDate = System.currentTimeMillis()
                dpd.show()
            }

            buttonAddBackTicket.setOnClickListener {
                val c = Calendar.getInstance()
                val yearNow = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val dpd =
                    DatePickerDialog(requireContext(), { _, year, monthOfYear, dayOfMonth ->
                        val textDate = requireContext().getString(
                            R.string.string_date,
                            dayOfMonth,
                            monthsConversion((monthOfYear + 1).toString()),
                            "сб"
                        )
                        date = getString(
                            R.string.departure_date,
                            dayNow,
                            fullMonthsConversion((monthOfYear + 1).toString())
                        )
                        buttonAddBackTicket.text = textDate
                    }, yearNow, month, day)
                dpd.datePicker.minDate = System.currentTimeMillis()
                dpd.show()
            }

            buttonShowAll.setOnClickListener {
                findNavController().navigate(
                    CountrySelectedFragmentDirections.actionCountrySelectedFragmentToAllTicketsFragment(
                        editTextCityFrom.text.toString(),
                        editTextCityTo.text.toString(),
                        date
                    )
                )
            }
        }
    }

    private fun monthsConversion(month: String?): String {
        when (month) {
            "1" -> return "янв"
            "2" -> return "фев"
            "3" -> return "мар"
            "4" -> return "апр"
            "5" -> return "май"
            "6" -> return "июн"
            "7" -> return "июл"
            "8" -> return "авг"
            "9" -> return "сен"
            "10" -> return "окт"
            "11" -> return "ноя"
            "12" -> return "дек"
        }
        return ""
    }

    private fun fullMonthsConversion(month: String?): String {
        when (month) {
            "1" -> return "январь"
            "2" -> return "февраль"
            "3" -> return "март"
            "4" -> return "апрель"
            "5" -> return "май"
            "6" -> return "июнь"
            "7" -> return "июль"
            "8" -> return "август"
            "9" -> return "сентябрь"
            "10" -> return "октябрь"
            "11" -> return "ноябрь"
            "12" -> return "декабрь"
        }
        return ""
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}