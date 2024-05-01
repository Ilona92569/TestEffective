package com.example.testeffective.feature.ui.airtickets.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testeffective.data.model.Offer
import com.example.testeffective.feature.databinding.ItemTravelOffersBinding

class TravelOfferAdapter(
    private val context: Context
) : ListAdapter<Offer, TravelOfferViewHolder>(DIFF_UTIL) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelOfferViewHolder =
        TravelOfferViewHolder(
            context,
            ItemTravelOffersBinding.inflate(LayoutInflater.from(context))
        )

    override fun onBindViewHolder(holder: TravelOfferViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Offer>() {
            override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.title == newItem.title &&
                        oldItem.price == newItem.price &&
                        oldItem.town == newItem.town
            }
        }
    }
}