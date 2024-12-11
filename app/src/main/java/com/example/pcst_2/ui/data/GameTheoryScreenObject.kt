package com.example.pcst_2.ui.data

import com.example.pcst_2.data.Game
import kotlinx.serialization.Serializable

@Serializable
data class GameTheoryScreenObject(
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
