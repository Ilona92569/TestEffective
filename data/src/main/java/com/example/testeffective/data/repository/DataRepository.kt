package com.example.testeffective.data.repository

import com.example.testeffective.data.data.getAllStraightFlights
import com.example.testeffective.data.data.getAllTickets
import com.example.testeffective.data.data.getAllTravelOffers
import com.example.testeffective.data.model.Offers
import com.example.testeffective.data.model.Tickets
import com.example.testeffective.data.model.TicketsOffers

class DataRepository {

    suspend fun getTravelOffers(): Offers = getAllTravelOffers()

    suspend fun getStraightFlights(): TicketsOffers = getAllStraightFlights()

    suspend fun getTickets(): Tickets = getAllTickets()
}