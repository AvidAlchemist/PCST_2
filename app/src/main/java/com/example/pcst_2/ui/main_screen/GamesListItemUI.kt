package com.example.pcst_2.ui.main_screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pcst_2.R
import com.example.pcst_2.data.Game

@Composable
fun GamesListItemUI(game: Game) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                1.dp,
                Color.Black,
                RoundedCornerShape(15.dp)
            )
    ) {
        AsyncImage(
            model = R.drawable.ic_games,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .width(80.dp)
                .clip(RoundedCornerShape(15.dp))
                .padding(start = 10.dp),

            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = game.title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxHeight()
        )
    }
}