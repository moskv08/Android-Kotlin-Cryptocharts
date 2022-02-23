package com.moskv08.cryptocurrencyapp.feature_coin.domain.use_case.get_coin_market_cap

import com.moskv08.cryptocurrencyapp.core.Resource
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.CoinDetail
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.CoinMarketCap
import com.moskv08.cryptocurrencyapp.feature_coin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinMarketCap @Inject constructor(private val repository: CoinRepository){
    operator fun invoke(): Flow<Resource<CoinMarketCap>> {
        return repository.getCoinMarketCap()
    }
}