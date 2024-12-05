package com.example.pcst_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pcst_2.ui.data.AddArticleScreenObject
import com.example.pcst_2.ui.add_article_screen.AddArticleScreen
import com.example.pcst_2.ui.add_game_screen.AddGameScreen
import com.example.pcst_2.ui.admin_panel_screen.AdminPanelScreen
import com.example.pcst_2.ui.data.AddGameScreenObject
import com.example.pcst_2.ui.data.AdminPanelScreenObject
import com.example.pcst_2.ui.login.LoginScreen
import com.example.pcst_2.ui.login.data.LoginScreenObject
import com.example.pcst_2.ui.main_screen.MainScreen
import com.example.pcst_2.ui.main_screen.data.MainScreenDataObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = LoginScreenObject) {

                composable<LoginScreenObject> {
                    LoginScreen { navData ->
                        navController.navigate(navData)
                    }
                }

                composable<MainScreenDataObject> { navEntry ->
                    val navData = navEntry.toRoute<MainScreenDataObject>()
                    MainScreen(
                        navData,
                        navController,
                        onGameEditClick = { game ->
                            navController.navigate(AddGameScreenObject(
                                key = game.key,
                                title = game.title,
                                theoryText = game.theoryText,
                                taskTitle = game.taskTitle,
                                taskText = game.taskText,
                                taskTip = game.taskTip,
                                taskCorrect = game.taskCorrect,
                                testText = game.testText,
                                testCorrect = game.testCorrect,
                                testSomeAnswer_1 = game.testSomeAnswer_1,
                                testSomeAnswer_2 = game.testSomeAnswer_2,
                                testSomeAnswer_3 = game.testSomeAnswer_3
                            ))
                        }
                    ) {
                        navController.navigate(AdminPanelScreenObject)
                    }
                }

                composable<AdminPanelScreenObject> { navEntry ->
                    AdminPanelScreen(navController)
                }

                composable<AddArticleScreenObject> { navEntry ->
                    AddArticleScreen {
                        navController.popBackStack()
                    }
                }

                composable<AddGameScreenObject> { navEntry ->
                    val navData = navEntry.toRoute<AddGameScreenObject>()
                    AddGameScreen(navData) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}
