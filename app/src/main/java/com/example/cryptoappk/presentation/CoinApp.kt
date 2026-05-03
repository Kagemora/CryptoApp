package com.example.cryptoappk.presentation

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoappk.data.workers.CoinWorkerFactory
import com.example.cryptoappk.di.DaggerApplicationComponent
import javax.inject.Inject


class CoinApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: CoinWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

}