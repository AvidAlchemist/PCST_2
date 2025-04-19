package com.example.pcst_2.ui.article_details_screen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pcst_2.ui.article_details_screen.data.ArticleTestObject
import com.example.pcst_2.ui.article_details_screen.data.ArticleTextObject

@Composable
fun ArticleTextScreen(
    navObject: ArticleTextObject = ArticleTextObject(),
    navController: NavHostController
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = navObject.articleTitle.replace("*space*","\n"),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .weight(1f) // Occupy remaining space
                .verticalScroll(rememberScrollState()) // Enable vertical scrolling
        ) {
            Text(
                text = navObject.articleText.replace("*space*","\n"),
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            onClick = {
                navController.popBackStack()
                navController.navigate(
                    ArticleTestObject(
                        key = navObject.key,
                        articleTitle = navObject.articleTitle,
                        articleText = navObject.articleText,
                        articleTestText = navObject.articleTestText,
                        articleTestCorrect = navObject.articleTestCorrect,
                        articleTestSomeAnswerOne = navObject.articleTestSomeAnswerOne,
                        articleTestSomeAnswerTwo = navObject.articleTestSomeAnswerTwo,
                        articleTestSomeAnswerThree = navObject.articleTestSomeAnswerThree
                    )
                )

            } ) {
            Text(text = "Продолжить")
        }
    }
}