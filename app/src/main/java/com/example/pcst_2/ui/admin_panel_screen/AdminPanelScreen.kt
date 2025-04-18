package com.example.pcst_2.ui.admin_panel_screen

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pcst_2.ui.data.AddArticleScreenObject
import com.example.pcst_2.ui.data.AddGameScreenObject

@Composable
fun AdminPanelScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate(AddGameScreenObject()) },
            modifier = Modifier.fillMaxWidth()) {
            Text("Добавить Мини-игру")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(AddArticleScreenObject()) },
            modifier = Modifier.fillMaxWidth()) {
            Text("Добавить Статью")
        }
    }
}