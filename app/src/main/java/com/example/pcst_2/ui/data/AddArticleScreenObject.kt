package com.example.pcst_2.ui.data

import kotlinx.serialization.Serializable

@Serializable
data class AddArticleScreenObject(
    val key : String = "",
    val articleTitle : String = "",
    val articleText : String = "",
    val articleTestText : String = "",
    val articleTestCorrect : String = "",
    val articleTestSomeAnswerOne : String = "",
    val articleTestSomeAnswerTwo : String = "",
    val articleTestSomeAnswerThree : String = ""
)