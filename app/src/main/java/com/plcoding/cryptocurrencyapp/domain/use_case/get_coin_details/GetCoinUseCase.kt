package com.plcoding.cryptocurrencyapp.domain.use_case.get_coin_details

import com.plcoding.cryptocurrencyapp.common.Resource
import com.plcoding.cryptocurrencyapp.domain.model.CoinDetail
import com.plcoding.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return repository.getCoinById(coinId)
    }
}