package com.example.pcst_2.data

//Нужно задать значение по умолчанию во избежание ошибки
data class Game(
    val key : String = "",
    val title : String = "",
    val theoryText : String = "",
    val taskTitle : String = "",
    val taskText : String = "",
    val taskTip : String = "",
    val taskCorrect : String = "",
    val testText : String = "",
    val testCorrect : String = "",
    val testSomeAnswerOne : String = "",
    val testSomeAnswerTwo : String = "",
    val testSomeAnswerThree : String = ""
)