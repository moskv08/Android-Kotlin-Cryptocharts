package com.moskv08.cryptocurrencyapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.theme.Shapes

private val DarkColorPalette = darkColors(
    primary = TextWhite,
    background = DeepBlue,
    onBackground = TextWhite,
    onPrimary = DeepBlue
)

private val LightColorPalette = lightColors(
    primary = DeepBlue,
    background = Color.White,
    onBackground = DeepBlue,
    onPrimary = DeepBlue
)

@Composable
fun CryptocurrencyAppTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}