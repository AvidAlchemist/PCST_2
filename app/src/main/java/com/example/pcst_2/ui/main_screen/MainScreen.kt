package com.example.pcst_2.ui.main_screen

import android.util.Log
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.pcst_2.data.Article
import com.example.pcst_2.data.Game
import com.example.pcst_2.ui.main_screen.bottom_menu.BottomMenu
import com.example.pcst_2.ui.main_screen.bottom_menu.BottomMenuItem
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
               onGameClick:(Game) -> Unit,
               onArticleClick: (Article) -> Unit,
               onAdminClick: () -> Unit,
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val itemsListState = remember {
        mutableStateOf(emptyList<Any>())
    }

    val selectedBottomItemState = remember {
        mutableStateOf(BottomMenuItem.Games.title)
    }

    val isAdminState = remember {
        mutableStateOf(false)
    }

    val isListEmptyState = remember {
        mutableStateOf(false)
    }

    val db = remember { Firebase.firestore }

    LaunchedEffect(Unit) {
        getAllGames(db) { games ->
            isListEmptyState.value = games.isEmpty()
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
                        selectedBottomItemState.value = BottomMenuItem.Games.title
                        getAllGames(db) { items ->
                            itemsListState.value = items
                        }
                        coroutineScope.launch {
                            drawerState.close()
                        }
                    },
                    onArticlesClick = {
                        selectedBottomItemState.value = BottomMenuItem.Articles.title
                        getAllArticles(db) { items ->
                            itemsListState.value = items
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
                    selectedBottomItemState.value,
                    onGamesClick = {
                        selectedBottomItemState.value = BottomMenuItem.Games.title
                        getAllGames(db) { games ->
                            isListEmptyState.value = games.isEmpty()
                            itemsListState.value = games
                        }
                    },
                    onArticlesClick = {
                        selectedBottomItemState.value = BottomMenuItem.Articles.title
                        getAllArticles(db) { articles ->
                            isListEmptyState.value = articles.isEmpty()
                            itemsListState.value = articles
                        }
                    }
                )
            }
        ) { paddingValues ->

            if (isListEmptyState.value) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Empty List!",
                        color = Color.Black
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(itemsListState.value) { item ->
                    when (item) {
                        is Game -> {
                            GamesListItemUI(
                                navController,
                                isAdminState.value,
                                item,
                                onEditClick = {
                                    onGameEditClick(it)
                                },
                                onGameClick = { game ->
                                    onGameClick(game)
                                }
                            )
                        }

                        is Article -> {
                            ArticlesListItemUI(
                                navController,
                                isAdminState.value,
                                item,
                                onEditClick = {
                                    onArticleEditClick(it)
                                },
                                onArticleClick = { article ->
                                    onArticleClick(article)
                                }
                            )
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