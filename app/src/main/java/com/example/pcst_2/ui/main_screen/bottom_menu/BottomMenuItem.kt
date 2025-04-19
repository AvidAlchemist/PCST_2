package com.example.pcst_2.ui.main_screen.bottom_menu

import com.example.pcst_2.R

sealed class BottomMenuItem(
    val route : String,
    val title : String,
    val iconId : Int
) {
//    object Home : BottomMenuItem(
//        route = "home",
//        title = "Home",
//        iconId = R.drawable.ic_home
//    )

    object Games : BottomMenuItem(
        route = "games",
        title = "Мини-игры",
        iconId = R.drawable.ic_games
    )

    object Articles : BottomMenuItem(
        route = "articles",
        title = "Статьи",
        iconId = R.drawable.ic_articles
    )

//    object Settings : BottomMenuItem(
//        route = "settings",
//        title = "Settings",
//        iconId = R.drawable.ic_settings
//    )
}