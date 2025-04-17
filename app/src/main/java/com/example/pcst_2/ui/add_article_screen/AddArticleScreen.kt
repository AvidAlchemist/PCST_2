package com.example.pcst_2.ui.add_article_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.pcst_2.data.Article
import com.example.pcst_2.ui.data.AddArticleScreenObject
import com.example.pcst_2.ui.login.LoginButton
import com.example.pcst_2.ui.login.RoundedCornerTextField
import com.example.pcst_2.ui.theme.BoxFilterColor
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
@Preview(showBackground = true)
fun AddArticleScreen(
    navData : AddArticleScreenObject = AddArticleScreenObject(),
    onSaved: () -> Unit = {}
) {

    val key = remember {
        mutableStateOf(navData.key)
    }
    val articleTitle = remember {
        mutableStateOf(navData.articleTitle)
    }
    val articleText = remember {
        mutableStateOf(navData.articleText)
    }
    val articleTestText = remember {
        mutableStateOf(navData.articleTestText)
    }
    val articleTestCorrect = remember {
        mutableStateOf(navData.articleTestCorrect)
    }
    val articleTestSomeAnswerOne = remember {
        mutableStateOf(navData.articleTestSomeAnswerOne)
    }
    val articleTestSomeAnswerTwo = remember {
        mutableStateOf(navData.articleTestSomeAnswerTwo)
    }
    val articleTestSomeAnswerThree = remember {
        mutableStateOf(navData.articleTestSomeAnswerThree)
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
//            modifier = Modifier.size(90.dp)
//        )
//        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Добавить статью",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(10.dp))
        RoundedCornerTextField(
            singleLine = false,
            maxLines = 2,
            text = articleTitle.value,
            label = "Заголовок"
        ) {
            articleTitle.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            maxLines = 2,
            text = articleText.value,
            label = "Текст"
        ) {
            articleText.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            maxLines = 2,
            text = articleTestText.value,
            label = "Текст теста"
        ) {
            articleTestText.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = articleTestCorrect.value,
            label = "Правильный ответ"
        ) {
            articleTestCorrect.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = articleTestSomeAnswerOne.value,
            label = "Ответ 1"
        ) {
            articleTestSomeAnswerOne.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = articleTestSomeAnswerTwo.value,
            label = "Ответ 2"
        ) {
            articleTestSomeAnswerTwo.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = articleTestSomeAnswerThree.value,
            label = "Ответ 3"
        ) {
            articleTestSomeAnswerThree.value = it
        }
        Spacer(modifier = Modifier.height(5.dp))

        LoginButton(text = "Сохранить") {
            saveArticleToFireStore(
                firestore,
                Article(
                    articleTitle = articleTitle.value,
                    articleText = articleText.value,
                    articleTestText = articleTestText.value,
                    articleTestCorrect = articleTestCorrect.value,
                    articleTestSomeAnswerOne = articleTestSomeAnswerOne.value,
                    articleTestSomeAnswerTwo = articleTestSomeAnswerTwo.value,
                    articleTestSomeAnswerThree = articleTestSomeAnswerThree.value
                ),
                onSaved = {
                    onSaved()
                },
                onError = {}
            )
        }
    }
}

private fun saveArticleToFireStore(
    firestore: FirebaseFirestore,
    article: Article,
    onSaved: () -> Unit,
    onError: () -> Unit
) {
    val db = firestore.collection("articles")
    if (article.key.isNotEmpty()) {
        db.document(article.key)
            .set(article)
            .addOnSuccessListener {
                onSaved()
            }
            .addOnFailureListener {
                onError()
            }
    } else {
        val newKey = db.document().id // Generate a new key
        db.document(newKey)
            .set(article.copy(key = newKey)) // Create a new document with the new key
            .addOnSuccessListener {
                onSaved()
            }
            .addOnFailureListener {
                onError()
            }
    }
}