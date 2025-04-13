package com.example.pcst_2.ui.article_details_screen.data

import kotlinx.serialization.Serializable

@Serializable
data class ArticleNavObject(
    val title: String = "",
    val description : String = ""
)
