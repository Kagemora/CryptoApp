package com.example.cryptoappk.di

import android.app.Application
import com.example.cryptoappk.presentation.CoinApp
import com.example.cryptoappk.presentation.CoinDetailFragment
import com.example.cryptoappk.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        WorkerModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)
    fun inject(coinApp: CoinApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}