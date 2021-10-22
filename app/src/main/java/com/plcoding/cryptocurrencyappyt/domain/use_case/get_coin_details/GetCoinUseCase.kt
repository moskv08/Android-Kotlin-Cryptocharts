package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin_details

import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository){
    suspend operator fun invoke(coinId: String){
        val coins = repository.getCoinById(coinId)
    }
}