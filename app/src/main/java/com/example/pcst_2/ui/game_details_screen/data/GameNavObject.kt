package com.example.pcst_2.ui.game_details_screen.data

import kotlinx.serialization.Serializable

@Serializable
data class GameNavObject(
    val title: String = "",
    val description : String = ""
)
