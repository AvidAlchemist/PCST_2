package com.example.pcst_2.ui.main_screen.data

import kotlinx.serialization.Serializable

@Serializable
data class MainScreenDataObject(
    val uid : String = "",
    val email: String = ""
)
