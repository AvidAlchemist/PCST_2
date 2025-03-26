package com.example.pcst_2.ui.add_game_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pcst_2.R
import com.example.pcst_2.data.Game
import com.example.pcst_2.ui.data.AddGameScreenObject
import com.example.pcst_2.ui.login.LoginButton
import com.example.pcst_2.ui.login.RoundedCornerTextField
import com.example.pcst_2.ui.theme.BoxFilterColor
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.Error

@Preview(showBackground = true)
@Composable
fun AddGameScreen(
    navData : AddGameScreenObject = AddGameScreenObject(),
    onSaved: () -> Unit = {}
) {

    val key = remember {
        mutableStateOf(navData.key)
    }
    val title = remember {
        mutableStateOf(navData.title)
    }
    val theoryText = remember {
        mutableStateOf(navData.theoryText)
    }
    val taskTitle = remember {
        mutableStateOf(navData.taskTitle)
    }
    val taskText = remember {
        mutableStateOf(navData.taskText)
    }
    val taskTip = remember {
        mutableStateOf(navData.taskTip)
    }
    val taskCorrect = remember {
        mutableStateOf(navData.taskCorrect)
    }
    val testText = remember {
        mutableStateOf(navData.testText)
    }
    val testCorrect = remember {
        mutableStateOf(navData.testCorrect)
    }
    val testSomeAnswer_1 = remember {
        mutableStateOf(navData.testSomeAnswer_1)
    }
    val testSomeAnswer_2 = remember {
        mutableStateOf(navData.testSomeAnswer_2)
    }
    val testSomeAnswer_3 = remember {
        mutableStateOf(navData.testSomeAnswer_3)
    }

    val firestore = remember {
        Firebase.firestore
    }

    Image(
        painter = painterResource(
            id = R.drawable.login_bg
        ),
        contentDescription = "background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        alpha = 0.9f
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BoxFilterColor)

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 50.dp,
                end = 50.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.login_logo),
//            contentDescription = "logo",
//            modifier = Modifier.size(65.dp)
//        )
//        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Add new Game",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(10.dp))
        RoundedCornerTextField(
            singleLine = false,
            maxLines = 2,
            text = title.value,
            label = "Title"
        ) {
            title.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            maxLines = 2,
            text = theoryText.value,
            label = "Theory Text"
        ) {
            theoryText.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            maxLines = 2,
            text = taskTitle.value,
            label = "Task Title"
        ) {
            taskTitle.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = taskText.value,
            label = "Task Text"
        ) {
            taskText.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = taskTip.value,
            label = "Task Tip"
        ) {
            taskTip.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = taskCorrect.value,
            label = "Task Correct"
        ) {
            taskCorrect.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = testText.value,
            label = "Test Text"
        ) {
            testText.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = testCorrect.value,
            label = "Test Correct"
        ) {
            testCorrect.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = testSomeAnswer_1.value,
            label = "Some Answer 1"
        ) {
            testSomeAnswer_1.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = testSomeAnswer_2.value,
            label = "Some Answer 2"
        ) {
            testSomeAnswer_2.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = testSomeAnswer_3.value,
            label = "Some Answer 3"
        ) {
            testSomeAnswer_3.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))

        LoginButton(text = "Save") {
            saveGameToFireStore(
                firestore = firestore,
                game = Game(
                    key = key.value,
                    title = title.value,
                    theoryText = theoryText.value,
                    taskTitle = taskTitle.value,
                    taskText = taskText.value,
                    taskTip = taskTip.value,
                    taskCorrect = taskCorrect.value,
                    testText = testText.value,
                    testCorrect = testCorrect.value,
                    testSomeAnswer_1 = testSomeAnswer_1.value,
                    testSomeAnswer_2 = testSomeAnswer_2.value,
                    testSomeAnswer_3 = testSomeAnswer_3.value
                ),
                onSaved = {
                    onSaved()
                },
                onError = {}
            )

        }
    }
}

private fun saveGameToFireStore(
    firestore: FirebaseFirestore,
    game: Game,
    onSaved: () -> Unit,
    onError: () -> Unit
) {
    val db = firestore.collection("games")
    if (game.key.isNotEmpty()) {
        db.document(game.key)
            .set(game)
            .addOnSuccessListener {
                onSaved()
            }
            .addOnFailureListener {
                onError()
            }
    } else {
        val newKey = db.document().id // Generate a new key
        db.document(newKey)
            .set(game.copy(key = newKey)) // Create a new document with the new key
            .addOnSuccessListener {
                onSaved()
            }
            .addOnFailureListener {
                onError()
            }
    }
}