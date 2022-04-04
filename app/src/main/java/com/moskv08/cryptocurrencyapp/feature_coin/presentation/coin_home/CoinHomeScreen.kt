package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home.components.*
import com.moskv08.cryptocurrencyapp.ui.theme.*
import com.moskv08.cryptocurrencyapp.R
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.top_header.TopHeaderBar

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
                        R.drawable.ic_play,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        content = null,
                        R.drawable.ic_play,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        content = null,
                        R.drawable.ic_play,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        content = null,
                        R.drawable.ic_play,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Thug island",
                        content = null,
                        R.drawable.ic_play,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Life sounds",
                        content = null,
                        R.drawable.ic_play,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    )
                )
            )
//            Text(
//                text = "Home Screen",
//                style = MaterialTheme.typography.h2
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "Last Updated: ${state.marketCap?.lastUpdated.toString()}",
//                textAlign = TextAlign.Center
//            )
        }
    }
}