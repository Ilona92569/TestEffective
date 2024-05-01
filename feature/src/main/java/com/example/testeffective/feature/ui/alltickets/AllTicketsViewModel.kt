package com.example.testeffective.feature.ui.alltickets

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testeffective.data.model.Tickets
import com.example.testeffective.data.repository.DataRepository

class AllTicketsViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    val listAllTickets = MutableLiveData<Tickets>()

    suspend fun getAllTickets() {
        listAllTickets.value = dataRepository.getTickets()
    }
}