package com.example.pcst_2.ui.article_details_screen.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.pcst_2.ui.article_details_screen.data.ArticleTestObject
import com.example.pcst_2.ui.article_details_screen.data.ArticleTextObject

@Composable
fun ArticleTestScreen(
    navObject: ArticleTestObject = ArticleTestObject(),
    navController: NavHostController
) {
    Text(text = "ArticleTestScreen")
}