package com.example.pcst_2.ui.game_theory_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pcst_2.ui.data.GameTaskScreenObject
import com.example.pcst_2.ui.data.GameTheoryScreenObject


@Composable
fun GameTheoryScreen(
    navData : GameTheoryScreenObject = GameTheoryScreenObject(),
    navController: NavHostController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = navData.title,
            style = MaterialTheme.typography.headlineLarge, // Increased font
            modifier = Modifier
            .fillMaxWidth() // Make text fill the width
            .wrapContentSize(Alignment.Center) // Center text horizontally
        )
        Box(
            modifier = Modifier
                .weight(1f) // Occupy remaining space
                .verticalScroll(rememberScrollState()) // Enable vertical scrolling
        ) {
            Text(
                text = navData.theoryText,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Button(
            onClick = {// Navigate to the next page
                navController.popBackStack()
                navController.navigate(GameTaskScreenObject(
                    key = navData.key,
                    title = navData.title,
                    theoryText = navData.theoryText,
                    taskTitle = navData.taskTitle,
                    taskText = navData.taskText,
                    taskTip = navData.taskTip,
                    taskCorrect = navData.taskCorrect,
                    testText = navData.testText,
                    testCorrect = navData.testCorrect,
                    testSomeAnswerOne = navData.testSomeAnswerOne,
                    testSomeAnswerTwo = navData.testSomeAnswerTwo,
                    testSomeAnswerThree = navData.testSomeAnswerThree
                ))

            },
            modifier = Modifier
                .fillMaxWidth() // Make button fill the width
                .wrapContentSize(Alignment.Center) // Center button horizontally
        ) {
            Text("Continue")
        }
    }
}