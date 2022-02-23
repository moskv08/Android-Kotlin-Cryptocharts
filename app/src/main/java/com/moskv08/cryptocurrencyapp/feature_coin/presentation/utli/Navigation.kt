package com.moskv08.cryptocurrencyapp.feature_coin.presentation.utli

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_detail.CoinDetailScreen
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home.CoinHomeScreen
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_list.CoinListScreen

/** TODO: Move into separated class **/
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(
            route = Screen.CoinHomeScreen.route
        ){
            CoinHomeScreen(navController)
        }
        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen(navController)
        }

        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen()
        }
        /** TODO: Implement Search section **/
        /** TODO: Implement Search section **/
    }
//    NavHost(navController = navController, startDestination = "home") {
//        composable("home") {
//            HomeScreen()
//        }
//        composable("coins") {
//            ChatScreen()
//        }
//        /** TODO: Implement Search section **/
//    }
}