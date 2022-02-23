package com.moskv08.cryptocurrencyapp.feature_coin.data.remote

import com.moskv08.cryptocurrencyapp.feature_coin.data.remote.dto.CoinDetailDto
import com.moskv08.cryptocurrencyapp.feature_coin.data.remote.dto.CoinDto
import com.moskv08.cryptocurrencyapp.feature_coin.data.remote.dto.CoinMarketCapDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId : String) : CoinDetailDto

    @GET("/v1/global")
    suspend fun getCoinMarketInfo() : CoinMarketCapDto
}