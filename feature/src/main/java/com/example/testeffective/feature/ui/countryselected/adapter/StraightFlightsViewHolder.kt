package com.example.testeffective.feature.ui.countryselected.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.testeffective.data.model.TicketsOffer
import com.example.testeffective.feature.R
import com.example.testeffective.feature.databinding.ItemStraightFlightBinding

class StraightFlightsViewHolder(
    private val context: Context,
    private val binding: ItemStraightFlightBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(ticketsOffer: TicketsOffer) {
        with(binding) {
            textTitle.text = ticketsOffer.title
            textTime.text = ticketsOffer.time_range.reduce { acc, s -> "$acc $s" }
            textPrice.text =
                context.getString(
                    R.string.price_flight,
                    convertPrice(ticketsOffer.price.value.toString())
                )
            when (ticketsOffer.id) {
                1 -> imageColor.setImageResource(R.color.special_red)
                10 -> imageColor.setImageResource(R.color.special_blue)
                30 -> imageColor.setImageResource(R.color.white)
            }
        }
    }

    private fun convertPrice(price: String): String {
        return "${price.substring(0, price.length - 3)} ${price.substring(price.length - 3)}"
    }
}