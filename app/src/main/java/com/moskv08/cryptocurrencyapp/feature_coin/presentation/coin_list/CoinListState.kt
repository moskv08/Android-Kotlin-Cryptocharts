package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_list

import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
