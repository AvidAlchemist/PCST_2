package com.example.pcst_2.ui.main_screen.bottom_menu

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource

@Composable
fun BottomMenu(
    onGamesClick: () -> Unit = {},
    onArticlesClick: () -> Unit = {}
) {
    val items = listOf(
        //BottomMenuItem.Home,
        BottomMenuItem.Games,
        BottomMenuItem.Articles,
        BottomMenuItem.Settings
    )

    val selectedItem = remember { mutableStateOf("Home") }

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = selectedItem.value == item.title,
                onClick = {
                    selectedItem.value = item.title
                    when(item.title) {
                        BottomMenuItem.Games.title -> onGamesClick()
                        BottomMenuItem.Articles.title -> onArticlesClick()
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }
}