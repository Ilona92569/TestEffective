package com.example.testeffective.feature.ui.countryselected.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.testeffective.data.model.TicketsOffer
import com.example.testeffective.feature.databinding.ItemStraightFlightBinding

class StraightFlightsAdapter(
    private val context: Context
) : ListAdapter<TicketsOffer, StraightFlightsViewHolder>(DIFF_UTIL) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StraightFlightsViewHolder =
        StraightFlightsViewHolder(context, ItemStraightFlightBinding.inflate(LayoutInflater.from(context)))

    override fun onBindViewHolder(holder: StraightFlightsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<TicketsOffer>() {
            override fun areItemsTheSame(oldItem: TicketsOffer, newItem: TicketsOffer): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: TicketsOffer, newItem: TicketsOffer): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.title == newItem.title &&
                        oldItem.price == newItem.price
            }
        }
    }
}