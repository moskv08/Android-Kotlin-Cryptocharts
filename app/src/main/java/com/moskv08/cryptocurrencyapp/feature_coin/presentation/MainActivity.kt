package com.moskv08.cryptocurrencyapp.feature_coin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.navigation.compose.rememberNavController
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.bottom_menu.BottomMenuBar
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.bottom_menu.components.BottomMenuBarItem
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.utli.Navigation
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.utli.Screen
import com.moskv08.cryptocurrencyapp.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomMenuBar(
                            items = listOf(
                                BottomMenuBarItem(
                                    name = "Home",
                                    route = Screen.CoinHomeScreen.route,
                                    icon = Icons.Default.Home
                                ),
                                BottomMenuBarItem(
                                    name = "List",
                                    route = Screen.CoinListScreen.route,
                                    icon = Icons.Default.List,
                                    // badgeCount = 300
                                ),
                                BottomMenuBarItem(
                                    name = "Favorites",
                                    route = Screen.CoinHomeScreen.route,
                                    icon = Icons.Default.Favorite,
                                ),
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}