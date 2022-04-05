package com.moskv08.cryptocurrencyapp.feature_coin.data.remote.dto

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.CoinMarketCap
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

data class CoinMarketCapDto(
    @SerializedName("bitcoin_dominance_percentage")
    val btcDominancePercentage: Double,
    @SerializedName("cryptocurrencies_number")
    val cryptocurrencies: Int,
    @SerializedName("last_updated")
    val lastUpdated: Long,
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

@RequiresApi(Build.VERSION_CODES.O)
fun CoinMarketCapDto.toCoinMarketCap(): CoinMarketCap {
    return CoinMarketCap (
        cryptocurrencies = cryptocurrencies,
        lastUpdated = convertToDate(lastUpdated),
        marketCapUsd = marketCapUsd,
        btcDominancePercentage = btcDominancePercentage
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertToDate(unixTime: Long): String {
    val dateTime = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(unixTime),
        ZoneId.systemDefault(),
    )
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")
    return dateTime.format(formatter)
}