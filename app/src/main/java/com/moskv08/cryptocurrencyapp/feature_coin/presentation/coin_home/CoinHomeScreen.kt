package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home.components.Feature
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home.components.FeatureSection
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.top_header.TopHeaderBar
import com.moskv08.cryptocurrencyapp.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoinHomeScreen(
    viewModel: CoinHomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            TopHeaderBar()
//            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
//            CurrentMeditation()
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Last Updated",
                        content = state.marketCap?.lastUpdated.toString(),
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Currencies",
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
                        title = "Calming sounds",
                        content = null,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Thug island",
                        content = null,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Life sounds",
                        content = null,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    )
                )
            )
        }
    }
}