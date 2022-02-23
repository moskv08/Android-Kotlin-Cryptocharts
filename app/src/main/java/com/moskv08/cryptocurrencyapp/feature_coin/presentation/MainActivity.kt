package com.moskv08.cryptocurrencyapp.feature_coin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.navigation.compose.rememberNavController
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.navigation.components.BottomNavItem
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.navigation.components.BottomNavigationBar
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.theme.CryptocurrencyAppTheme
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.utli.Navigation
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.utli.Screen
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
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = Screen.CoinHomeScreen.route,
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = "List",
                                    route = Screen.CoinListScreen.route,
                                    icon = Icons.Default.Notifications,
                                    badgeCount = 300
                                ),
//                                BottomNavItem(
//                                    name = "Search",
//                                    route = "#",
//                                    icon = Icons.Default.Search,
//                                ),
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