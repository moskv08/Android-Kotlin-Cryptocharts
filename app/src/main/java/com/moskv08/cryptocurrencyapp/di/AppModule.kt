package com.moskv08.cryptocurrencyapp.di

import com.moskv08.cryptocurrencyapp.core.Constants
import com.moskv08.cryptocurrencyapp.feature_coin.data.remote.CoinPaprikaApi
import com.moskv08.cryptocurrencyapp.feature_coin.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return com.moskv08.cryptocurrencyapp.feature_coin.data.repository.CoinRepository(api)
    }
}