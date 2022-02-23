package com.moskv08.cryptocurrencyapp.feature_coin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.theme.CryptocurrencyAppTheme
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.utli.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    // Initiate Navigation
                    val navController = rememberNavController()
                    Navigation(navController = navController)
                }
            }
        }
    }
}