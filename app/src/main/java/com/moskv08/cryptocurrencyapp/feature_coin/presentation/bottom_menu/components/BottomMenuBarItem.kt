package com.moskv08.cryptocurrencyapp.feature_coin.presentation.bottom_menu.components

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomMenuBarItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)