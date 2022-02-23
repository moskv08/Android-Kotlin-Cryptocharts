package com.moskv08.cryptocurrencyapp.feature_coin.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.CoinMarketCap

data class CoinMarketCapDto(
    val bitcoin_dominance_percentage: Double,
    @SerializedName("cryptocurrencies_number")
    val cryptocurrencies: Int,
    @SerializedName("last_updated")
    val lastUpdated: Int,
    val market_cap_ath_date: String,
    val market_cap_ath_value: Long,
    val market_cap_change_24h: Double,
    @SerializedName("market_cap_usd")
    val marketCapUsd: Long,
    val volume_24h_ath_date: String,
    val volume_24h_ath_value: Long,
    val volume_24h_change_24h: Double,
    val volume_24h_percent_from_ath: Double,
    val volume_24h_percent_to_ath: Double,
    val volume_24h_usd: Long
)

fun CoinMarketCapDto.toCoinMarketCap(): CoinMarketCap {
    return CoinMarketCap (
        cryptocurrencies = cryptocurrencies,
        lastUpdated = lastUpdated,
        marketCapUsd = marketCapUsd
    )
}