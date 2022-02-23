package com.moskv08.cryptocurrencyapp.feature_coin.presentation.utli

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
    object CoinHomeScreen: Screen("home")
}
