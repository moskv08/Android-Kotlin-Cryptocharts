package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto

interface CoinRepository {

    // API Call to return a list of coins
    suspend fun getCoins(): List<CoinDto>

    // API call to return a single coin by its id
    suspend fun getCoinById(coinId: String): CoinDetailDto
}