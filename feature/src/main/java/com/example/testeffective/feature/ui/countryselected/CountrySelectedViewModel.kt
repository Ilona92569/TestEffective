package com.example.testeffective.feature.ui.countryselected

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testeffective.data.repository.DataRepository
import com.example.testeffective.data.model.TicketsOffers

class CountrySelectedViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    val listStraightFlights = MutableLiveData<TicketsOffers>()

    suspend fun getStraightFlights() {
        listStraightFlights.value = dataRepository.getStraightFlights()
    }
}