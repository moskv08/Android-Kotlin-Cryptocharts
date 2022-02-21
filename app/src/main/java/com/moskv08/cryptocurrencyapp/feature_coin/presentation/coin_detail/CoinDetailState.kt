package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_detail

import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
