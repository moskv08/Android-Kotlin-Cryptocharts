package com.plcoding.cryptocurrencyapp.domain.repository

import com.plcoding.cryptocurrencyapp.common.Resource
import com.plcoding.cryptocurrencyapp.domain.model.Coin
import com.plcoding.cryptocurrencyapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    // API Call to return a list of coins
    fun getCoins(): Flow<Resource<List<Coin>>>

    // API call to return a single coin by its id
    fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}