package com.example.testeffective.feature.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.testeffective.feature.ui.airtickets.AirTicketsViewModel
import com.example.testeffective.feature.ui.countryselected.CountrySelectedViewModel
import com.example.testeffective.feature.ui.alltickets.AllTicketsViewModel

val viewModelModule = module {
    viewModelOf(::AirTicketsViewModel)
    viewModelOf(::CountrySelectedViewModel)
    viewModelOf(::AllTicketsViewModel)
}