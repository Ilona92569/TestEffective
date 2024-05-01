package com.example.testeffective.feature.ui.airtickets

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testeffective.data.repository.DataRepository
import com.example.testeffective.data.model.Offers

class AirTicketsViewModel(
    private val dataRepository: DataRepository
) : ViewModel(){

    val listTravelOffers = MutableLiveData<Offers>()

    suspend fun getTravelOffers() {
        listTravelOffers.value = dataRepository.getTravelOffers()
    }
}