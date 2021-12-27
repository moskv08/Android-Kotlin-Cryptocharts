package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    // API Call to return a list of coins
    fun getCoins(): Flow<Resource<List<Coin>>>

    // API call to return a single coin by its id
    suspend fun getCoinById(coinId: String): CoinDetail
}