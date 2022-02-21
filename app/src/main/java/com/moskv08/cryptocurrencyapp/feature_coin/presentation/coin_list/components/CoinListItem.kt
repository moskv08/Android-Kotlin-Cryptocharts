package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            // Text(text = msg.author)
            Text(
                text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            // Text(text = msg.body)
            Text(
                text = if (coin.isActive) "active" else "inactive",
                color = if (coin.isActive) Color.Green else Color.Red,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body2,
//                modifier = Modifier.align(CenterVertically)
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