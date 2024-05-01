package com.example.testeffective

import android.app.Application
import com.example.testeffective.data.di.repositoryModule
import com.example.testeffective.feature.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestEffectiveApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@TestEffectiveApplication)
            modules(
                listOf(
                    viewModelModule,
                    repositoryModule,
                )
            )
        }
    }
}