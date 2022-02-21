package com.moskv08.cryptocurrencyapp.feature_coin.domain.use_case.get_coins

import com.moskv08.cryptocurrencyapp.core.Resource
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.Coin
import com.moskv08.cryptocurrencyapp.feature_coin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository){
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoins()
    }
}