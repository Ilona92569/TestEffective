package com.example.testeffective.feature.ui.alltickets.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.testeffective.data.model.Offer
import com.example.testeffective.data.model.Ticket
import com.example.testeffective.data.model.Tickets
import com.example.testeffective.feature.databinding.ItemInfoFlightsBinding

class InfoTicketAdapter(
    private val context: Context
) : ListAdapter<Ticket, InfoTicketViewHolder>(DIFF_UTIL) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoTicketViewHolder {
        val view = ItemInfoFlightsBinding.inflate(LayoutInflater.from(context))
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.root.layoutParams = layoutParams
       return InfoTicketViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: InfoTicketViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Ticket>() {
            override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.price == newItem.price &&
                        oldItem.has_transfer == newItem.has_transfer &&
                        oldItem.has_visa_transfer == newItem.has_visa_transfer &&
                        oldItem.is_exchangable == newItem.is_exchangable &&
                        oldItem.is_returnable == newItem.is_returnable &&
                        oldItem.arrival == newItem.arrival &&
                        oldItem.badge == newItem.badge &&
                        oldItem.company == newItem.company &&
                        oldItem.departure == newItem.departure &&
                        oldItem.hand_luggage == newItem.hand_luggage &&
                        oldItem.provider_name == newItem.provider_name &&
                        oldItem.luggage == newItem.luggage
            }
        }
    }
}