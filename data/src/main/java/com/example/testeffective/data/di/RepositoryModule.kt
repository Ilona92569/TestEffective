package com.example.testeffective.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.example.testeffective.data.repository.DataRepository

val repositoryModule = module {
    singleOf(::DataRepository)
}