package com.moskv08.cryptocurrencyapp.feature_coin.domain.model

data class CoinMarketCap(
    val cryptocurrencies: Int,
    val lastUpdated: String,
    val marketCapUsd: String,
    val btcDominancePercentage: Double,
)