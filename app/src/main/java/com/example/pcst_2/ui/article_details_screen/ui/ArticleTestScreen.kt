package com.example.pcst_2.ui.article_details_screen.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pcst_2.ui.article_details_screen.data.ArticleTestObject
import com.example.pcst_2.ui.article_details_screen.data.ArticleTextObject

@Composable
fun ArticleTestScreen(
    navData: ArticleTestObject = ArticleTestObject(),
    navController: NavHostController
) {
    val answers = remember {
        listOf(
            navData.articleTestSomeAnswerOne,
            navData.articleTestSomeAnswerTwo,
            navData.articleTestSomeAnswerThree,
            navData.articleTestCorrect)
            .shuffled() }
    var selectedAnswer = remember { mutableStateOf("answer") }
    var showError = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Закрепление пройденного",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        Text(
            text = navData.articleTestText.replace("*space*","\n"),
            fontSize = 18.sp,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        answers.forEach { answer ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedAnswer.value == answer,
                    onClick = { selectedAnswer.value = answer
                        showError.value = false}
                )
                Text(text = answer)
            }
        }

        // Error message (initially invisible)
        if (showError.value) {
            Text(
                text = "Неправильный ответ!",
                color = Color.Red,
                modifier = Modifier.padding(top = 4.dp)
            )
        } else {
            Spacer(modifier = Modifier.height(0.dp)) // Invisible spacer
        }

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                if (selectedAnswer.value == navData.articleTestCorrect) {
                    Toast.makeText(navController.context,
                        "Статья завершена успешно!", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                } else {
                    showError.value = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            Text("Проверить")
        }
    }
}