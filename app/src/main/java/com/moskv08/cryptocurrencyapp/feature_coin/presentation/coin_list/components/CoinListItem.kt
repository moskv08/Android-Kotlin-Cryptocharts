package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.Coin
import com.moskv08.cryptocurrencyapp.R

@Preview("")
@Composable
fun MyCoinListItemPreview() {
    CoinListItem(
        coin = Coin(
            id = "btc",
            isActive = true,
            name = "Bitcoin",
            rank = 1,
            symbol = "BTC",
        ),
        onItemClick = {}
    )
}

@Composable
fun CoinListItem(
    coin: Coin, onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Box(modifier = Modifier){
            Image(
                painter = painterResource(R.drawable.img_coin_list_item),
                contentDescription = "Coin Image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                alpha = 0.4f
            )
            Text(
                modifier = Modifier
                    .width(40.dp)
                    .padding(horizontal = 0.dp, vertical = 4.dp),
                textAlign = TextAlign.Center,
                text = "${coin.rank}",
                style = MaterialTheme.typography.h6,
            )
        }

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = coin.name,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = if (coin.isActive) "Active" else "Inactive",
                color = if (coin.isActive) Color.Green else Color.Red,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body2,
//                modifier = Modifier.align(CenterVertically)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                ,
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                /** TODO: Implement Favorit logic **/
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite"
            )
        }
    }

//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { onItemClick(coin) }
//            .padding(20.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(
//            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
//            style = MaterialTheme.typography.body1,
//            overflow = TextOverflow.Ellipsis
//        )
//
//        Text(
//            text = if(coin.isActive) "active" else "inactive",
//            color = if(coin.isActive) Color.Green else Color.Red,
//            fontStyle = FontStyle.Italic,
//            textAlign = TextAlign.End,
//            style = MaterialTheme.typography.body2,
//            modifier = Modifier.align(CenterVertically)
//        )
//    }
}