package com.moskv08.cryptocurrencyapp.domain.use_case.get_coin_details

import com.moskv08.cryptocurrencyapp.common.Resource
import com.moskv08.cryptocurrencyapp.domain.model.CoinDetail
import com.moskv08.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return repository.getCoinById(coinId)
    }
}