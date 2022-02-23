package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home

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

@Composable
fun CoinHomeScreen(
    viewModel: CoinHomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Home screen",
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Last Updated: ${state.marketCap?.lastUpdated.toString()}",
                textAlign = TextAlign.Center
            )
        }
    }
}