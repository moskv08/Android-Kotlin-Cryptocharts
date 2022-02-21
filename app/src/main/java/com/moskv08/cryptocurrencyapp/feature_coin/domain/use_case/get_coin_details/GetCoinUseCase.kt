package com.moskv08.cryptocurrencyapp.feature_coin.domain.use_case.get_coin_details

import com.moskv08.cryptocurrencyapp.core.Resource
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.CoinDetail
import com.moskv08.cryptocurrencyapp.feature_coin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return repository.getCoinById(coinId)
    }
}