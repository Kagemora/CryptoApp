package com.example.cryptoappk.di

import android.app.Application
import com.example.cryptoappk.data.database.AppDatabase
import com.example.cryptoappk.data.database.CoinInfoDao
import com.example.cryptoappk.data.network.ApiFactory
import com.example.cryptoappk.data.network.ApiService
import com.example.cryptoappk.data.repository.CoinRepositoryImpl
import com.example.cryptoappk.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}