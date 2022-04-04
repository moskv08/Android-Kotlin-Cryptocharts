package com.moskv08.cryptocurrencyapp.feature_coin.presentation.bottom_menu

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.bottom_menu.components.BottomMenuBarItem
import com.moskv08.cryptocurrencyapp.ui.theme.ButtonBlue
import com.moskv08.cryptocurrencyapp.ui.theme.DeepBlue
import com.moskv08.cryptocurrencyapp.ui.theme.TextWhite

@ExperimentalMaterialApi
@Composable
fun BottomMenuBar(
    items: List<BottomMenuBarItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomMenuBarItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = DeepBlue,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = ButtonBlue,
                unselectedContentColor = TextWhite,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if(item.badgeCount > 0) {
                            BadgeBox(
                                badgeContent = {
                                    Text(text = item.badgeCount.toString())
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }
                        if(selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}