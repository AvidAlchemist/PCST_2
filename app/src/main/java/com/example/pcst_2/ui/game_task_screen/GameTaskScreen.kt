package com.example.pcst_2.ui.game_task_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pcst_2.ui.data.GameTaskScreenObject
import com.example.pcst_2.ui.data.GameTestScreenObject

@Composable
fun GameTaskScreen(navData: GameTaskScreenObject, navController: NavHostController) {
    var inputText = remember { mutableStateOf("") }
    var showError = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = navData.title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        Text(
            text = navData.taskText,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Tip",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = navData.taskTip,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = inputText.value,
            onValueChange = { inputText.value = it
                            showError.value = false},
            label = { Text("Enter your answer") },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )

        if (showError.value) {Text(
            text = "Wrong answer, try again",
            color = Color.Red,
            modifier = Modifier.padding(top = 4.dp)
        )
        } else {
            Spacer(modifier = Modifier.height(0.dp))
        }

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                if (inputText.value == navData.taskCorrect) {
                    showError.value = false
                    navController.popBackStack()
                    navController.navigate(
                        GameTestScreenObject(
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
                        )
                        )
                } else {
                    showError.value = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            Text("Continue")
        }
    }
}