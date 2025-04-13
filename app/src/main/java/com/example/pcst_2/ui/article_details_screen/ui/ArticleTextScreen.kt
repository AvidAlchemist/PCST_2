package com.example.pcst_2.ui.article_details_screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
            text = navObject.title,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = navObject.description,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.popBackStack()
                navController.navigate(
                    ArticleTestObject(
                        title = navObject.title,
                        description = navObject.description
                    )
                )

            }) {
            Text(text = "Continue")
        }
    }
}