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
import com.example.pcst_2.ui.article_details_screen.data.ArticleTestObject
import com.example.pcst_2.ui.article_details_screen.data.ArticleTextObject
import com.example.pcst_2.ui.article_details_screen.ui.ArticleTestScreen
import com.example.pcst_2.ui.article_details_screen.ui.ArticleTextScreen
import com.example.pcst_2.ui.data.AddGameScreenObject
import com.example.pcst_2.ui.data.AdminPanelScreenObject
import com.example.pcst_2.ui.game_details_screen.data.GameTaskScreenObject
import com.example.pcst_2.ui.game_details_screen.data.GameTestScreenObject
import com.example.pcst_2.ui.game_details_screen.data.GameTheoryScreenObject
import com.example.pcst_2.ui.game_details_screen.ui.GameTaskScreen
import com.example.pcst_2.ui.game_details_screen.ui.GameTestScreen
import com.example.pcst_2.ui.game_details_screen.ui.GameTheoryScreen
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
                        onGameClick = { game ->
                            navController.navigate(GameTheoryScreenObject(
                                key = game.key,
                                title = game.title,
                                theoryText = game.theoryText,
                                taskTitle = game.taskTitle,
                                taskText = game.taskText,
                                taskTip = game.taskTip,
                                taskCorrect = game.taskCorrect,
                                testText = game.testText,
                                testCorrect = game.testCorrect,
                                testSomeAnswerOne = game.testSomeAnswerOne,
                                testSomeAnswerTwo = game.testSomeAnswerTwo,
                                testSomeAnswerThree = game.testSomeAnswerThree
                            ))
                        },
                        onArticleClick = {article ->
                            navController.navigate(ArticleTextObject(
                                key = article.key,
                                articleTitle = article.articleTitle,
                                articleText = article.articleText,
                                articleTestText = article.articleTestText,
                                articleTestCorrect = article.articleTestCorrect,
                                articleTestSomeAnswerOne = article.articleTestSomeAnswerOne,
                                articleTestSomeAnswerTwo = article.articleTestSomeAnswerTwo,
                                articleTestSomeAnswerThree = article.articleTestSomeAnswerThree
                            ))
                        },
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
                                testSomeAnswerOne = game.testSomeAnswerOne,
                                testSomeAnswerTwo = game.testSomeAnswerTwo,
                                testSomeAnswerThree = game.testSomeAnswerThree
                            ))
                        },
                        onArticleEditClick = {article ->
                            navController.navigate(AddArticleScreenObject(
                                key = article.key,
                                articleTitle = article.articleTitle,
                                articleText = article.articleText,
                                articleTestText = article.articleTestText,
                                articleTestCorrect = article.articleTestCorrect,
                                articleTestSomeAnswerOne = article.articleTestSomeAnswerOne,
                                articleTestSomeAnswerTwo = article.articleTestSomeAnswerTwo,
                                articleTestSomeAnswerThree = article.articleTestSomeAnswerThree
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
                    val navData = navEntry.toRoute<AddArticleScreenObject>()
                    AddArticleScreen(navData) {
                        navController.popBackStack()
                    }
                }

                composable<AddGameScreenObject> { navEntry ->
                    val navData = navEntry.toRoute<AddGameScreenObject>()
                    AddGameScreen(navData) {
                        navController.popBackStack()
                    }
                }

                composable<ArticleTextObject> { navEntry ->
                    val navData = navEntry.toRoute<ArticleTextObject>()
                    ArticleTextScreen(navData, navController)
                }

                composable<ArticleTestObject> { navEntry ->
                    val navData = navEntry.toRoute<ArticleTestObject>()
                    ArticleTestScreen(navData, navController)
                }

                composable<GameTheoryScreenObject> { navEntry ->
                    val navData = navEntry.toRoute<GameTheoryScreenObject>()
                    GameTheoryScreen(navData, navController)
                }

                composable<GameTaskScreenObject> { navEntry ->
                    val navData = navEntry.toRoute<GameTaskScreenObject>()
                    GameTaskScreen(navData, navController)
                }

                composable<GameTestScreenObject> { navEntry ->
                    val navData = navEntry.toRoute<GameTestScreenObject>()
                    GameTestScreen(navData, navController)
                }
            }
        }
    }
}  