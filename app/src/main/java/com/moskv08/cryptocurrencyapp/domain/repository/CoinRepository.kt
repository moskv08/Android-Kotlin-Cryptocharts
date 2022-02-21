package com.moskv08.cryptocurrencyapp.domain.repository

import com.moskv08.cryptocurrencyapp.common.Resource
import com.moskv08.cryptocurrencyapp.domain.model.Coin
import com.moskv08.cryptocurrencyapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    // API Call to return a list of coins
    fun getCoins(): Flow<Resource<List<Coin>>>

    // API call to return a single coin by its id
    fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}