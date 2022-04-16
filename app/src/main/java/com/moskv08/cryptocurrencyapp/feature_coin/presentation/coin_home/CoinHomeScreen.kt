package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home.components.Feature
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home.components.FeatureItem
import com.moskv08.cryptocurrencyapp.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoinHomeScreen(
    viewModel: CoinHomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(top = 50.dp, start = 7.5.dp, end = 7.5.dp),
        modifier = Modifier.fillMaxHeight(),
    ) {
        val features = listOf(
            Feature(
                title = "Last Updated",
                content = state.marketCap?.lastUpdated.toString(),
                BlueViolet1,
                BlueViolet2,
                BlueViolet3
            ),
            Feature(
                title = "Total Currencies",
                content = state.marketCap?.cryptocurrencies.toString(),
                LightGreen1,
                LightGreen2,
                LightGreen3
            ),
            Feature(
                title = "Market Capacity",
                content = state.marketCap?.marketCapUsd.toString(),
                OrangeYellow1,
                OrangeYellow2,
                OrangeYellow3
            ),
            Feature(
                title = "BTC Dominance",
                content = "${state.marketCap?.btcDominancePercentage.toString()} %",
                Beige1,
                Beige2,
                Beige3
            )
        )
        items(features.size) {
            FeatureItem(feature = features[it])
        }
    }
}