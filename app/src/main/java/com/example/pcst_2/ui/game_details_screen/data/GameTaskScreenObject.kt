package com.example.pcst_2.ui.game_details_screen.data

import kotlinx.serialization.Serializable

@Serializable

data class GameTaskScreenObject(
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