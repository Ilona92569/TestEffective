package com.example.testeffective.feature.ui.alltickets.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.testeffective.data.model.Ticket
import com.example.testeffective.feature.R
import com.example.testeffective.feature.databinding.ItemInfoFlightsBinding
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class InfoTicketViewHolder(
    private val context: Context,
    private val binding: ItemInfoFlightsBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(ticket: Ticket) {
        with(binding) {

            if (!ticket.badge.isNullOrEmpty()) {
                buttonAdditionalInformation.text = ticket.badge
            } else buttonAdditionalInformation.visibility = View.GONE

            textPrice.text = context.getString(R.string.price_flight, convertPrice(ticket.price.value.toString()))

            textArrivalTime.text = convertDate(ticket.arrival.date)
            textDepartureTime.text = convertDate(ticket.departure.date)

            textDepartureAirport.text = ticket.departure.airport
            textArrivalAirport.text = ticket.arrival.airport

            if (ticket.has_transfer)
                textAboutTime.text = context.getString(
                    R.string.info_about_time,
                    calculateFlightDuration(ticket.departure.date, ticket.arrival.date).toString(),
                    ""
                )
            else textAboutTime.text = context.getString(
                R.string.info_about_time,
                calculateFlightDuration(ticket.departure.date, ticket.arrival.date).toString(),
                context.getString(R.string.info_about_transfer)
            )

        }
    }

    private fun convertDate(date: String): String {
        val mass = date.split("T")
        return mass[1].substring(0, mass[1].lastIndexOf(":"))
    }

    private fun calculateFlightDuration(departureDateTime: String, arrivalDateTime: String): Double {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        val departure = LocalDateTime.parse(departureDateTime, formatter)
        val arrival = LocalDateTime.parse(arrivalDateTime, formatter)

        val duration = Duration.between(departure, arrival)
        val hours = ((duration.toMinutes() / 60.0) * 10).toInt() / 10.0
        return hours
    }
    private fun convertPrice(price: String): String {
        return "${price.substring(0, price.length - 3)} ${price.substring(price.length - 3)}"
    }
}