package com.example.pcst_2.ui.main_screen

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
               onAdminClick: () -> Unit
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val gamesListState = remember {
        mutableStateOf(emptyList<Game>())
    }
    val isAdminState = remember {
        mutableStateOf(false)
    }
    
    LaunchedEffect(Unit) {
        val db = Firebase.firestore
        getAllGames(db) { games ->  
            gamesListState.value = games
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
                    }
                ){
                    coroutineScope.launch {
                        drawerState.close()
                    }
                    onAdminClick()
                }
            }

        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomMenu() }
        ) { paddingValues ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier.fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(gamesListState.value) { game ->
                    GamesListItemUI(navController,isAdminState.value, game) {game ->
                        onGameEditClick(game)
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