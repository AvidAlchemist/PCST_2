package com.example.pcst_2.data

//Нужно задать значение по умолчанию во избежание ошибки
data class Article(
    val articleImageUrl : String = "",
    val articleText : String = "",
    val articleTestText : String = "",
    val articleTestCorrect : String = "",
    val articleTestSomeAnswer_1 : String = "",
    val articleTestSomeAnswer_2 : String = "",
    val articleTestSomeAnswer_3 : String = ""
)
