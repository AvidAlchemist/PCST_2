package com.example.pcst_2.data

//Нужно задать значение по умолчанию во избежание ошибки
data class Article(
    val key : String = "",
    val articleTitle : String = "",
    val articleText : String = "",
    val articleTestText : String = "",
    val articleTestCorrect : String = "",
    val articleTestSomeAnswerOne : String = "",
    val articleTestSomeAnswerTwo : String = "",
    val articleTestSomeAnswerThree : String = ""
)