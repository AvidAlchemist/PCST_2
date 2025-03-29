package com.example.pcst_2.ui.main_screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pcst_2.data.Article
import com.example.pcst_2.data.Game
import com.example.pcst_2.ui.main_screen.bottom_menu.BottomMenu
import com.example.pcst_2.ui.main_screen.data.MainScreenDataObject
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navData: MainScreenDataObject,
               navController: NavHostController,
               onGameEditClick: (Game) -> Unit,
               onArticleEditClick: (Article) -> Unit,
               onAdminClick: () -> Unit
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val itemsListState = remember {
        mutableStateOf(emptyList<Any>())
    }
//    val articlesListState = remember {
//        mutableStateOf(emptyList<Article>())
//    }
    val isAdminState = remember {
        mutableStateOf(false)
    }

    val db = remember { Firebase.firestore }

    LaunchedEffect(Unit) {
        getAllGames(db) { games ->
            itemsListState.value = games
        }
    }


    ModalNavigationDrawer(
        drawerState = drawerState,
        modifier = Modifier.fillMaxWidth(),
        drawerContent = {
            Column(Modifier.fillMaxWidth(0.7f)) {
                DrawerHeader(email = navData.email)
                DrawerBody(
                    onAdmin = { isAdmin ->
                        isAdminState.value = isAdmin
                    },
                    onAdminClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        onAdminClick()
                    },
                    onGamesClick = {
                        getAllGames(db) { games ->
                            itemsListState.value = games
                        }
                        coroutineScope.launch {
                            drawerState.close()
                        }
                    }
                )
            }

        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomMenu(
                    onGamesClick = {
                        getAllGames(db) { games ->
                            itemsListState.value = games
                        }
                    },
                    onArticlesClick = {
                        getAllArticles(db) { articles ->
                            itemsListState.value = articles
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(itemsListState.value) { item ->
                    when(item) {
                        is Game -> {
                            GamesListItemUI(navController,isAdminState.value, item) { game ->
                            onGameEditClick(game)
                            }
                            Log.d("NavigationTest", "GAME FOUND")
                        }
                        is Article -> {
                            ArticlesListItemUI(navController, isAdminState.value, item) { article ->
                                onArticleEditClick(article)
                            }
                            Log.d("NavigationTest","ARTICLE FOUND")
                            }
                    }
                }
            }
        }
    }
}

private fun getAllGames(
    db : FirebaseFirestore,
    onGames: (List<Game>) -> Unit
) {
    db.collection("games")
        .get()
        .addOnSuccessListener { task ->
            onGames(task.toObjects(Game::class.java))
        }
}

private fun getAllArticles(
    db : FirebaseFirestore,
    onArticles: (List<Article>) -> Unit
) {
    db.collection("articles")
        .get()
        .addOnSuccessListener { task ->
            onArticles(task.toObjects(Article::class.java))
        }
}