package com.example.pcst_2.ui.data

import kotlinx.serialization.Serializable

@Serializable
data class AddGameScreenObject(
    val key : String = "",
    val title : String = "",
    val theoryText : String = "",
    val taskTitle : String = "",
    val taskText : String = "",
    val taskTip : String = "",
    val taskCorrect : String = "",
    val testText : String = "",
    val testCorrect : String = "",
    val testSomeAnswer_1 : String = "",
    val testSomeAnswer_2 : String = "",
    val testSomeAnswer_3 : String = ""
)