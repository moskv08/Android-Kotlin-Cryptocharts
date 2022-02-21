package com.moskv08.cryptocurrencyapp.domain.use_case.get_coins

import com.moskv08.cryptocurrencyapp.common.Resource
import com.moskv08.cryptocurrencyapp.domain.model.Coin
import com.moskv08.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository){
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoins()
    }
}