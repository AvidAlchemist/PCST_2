package com.example.pcst_2.ui.article_details_screen.data

import kotlinx.serialization.Serializable

@Serializable
data class ArticleTestObject(
    val key : String = "",
    val articleTitle : String = "",
    val articleText : String = "",
    val articleTestText : String = "",
    val articleTestCorrect : String = "",
    val articleTestSomeAnswerOne : String = "",
    val articleTestSomeAnswerTwo : String = "",
    val articleTestSomeAnswerThree : String = ""
)
