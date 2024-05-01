package com.example.testeffective.feature.ui.airtickets.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.testeffective.data.model.Offer
import com.example.testeffective.feature.R
import com.example.testeffective.feature.databinding.ItemTravelOffersBinding

class TravelOfferViewHolder(
    private val context: Context,
    private val binding: ItemTravelOffersBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(offer: Offer) {
        with(binding) {
            textTitle.text = offer.title
            textCity.text = offer.town
            textPrice.text = context.getString(R.string.price_flight, convertPrice(offer.price.value.toString()))
            when (offer.id) {
                1 -> imageOffer.setImageResource(R.drawable.image_id_1)
                2 -> imageOffer.setImageResource(R.drawable.image_id_2)
                3 -> imageOffer.setImageResource(R.drawable.image_id_3)
            }
        }
    }

    private fun convertPrice(price: String): String {
        return "${price.substring(0, price.length - 3)} ${price.substring(price.length - 3)}"
    }
}