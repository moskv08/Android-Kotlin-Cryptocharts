package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home

import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.CoinMarketCap

data class CoinHomeState(
    val isLoading: Boolean = false,
    val marketCap: CoinMarketCap? = null,
    val error: String = ""
)
