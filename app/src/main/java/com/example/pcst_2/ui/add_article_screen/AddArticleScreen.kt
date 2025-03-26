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
import com.example.pcst_2.data.Article
import com.example.pcst_2.ui.login.LoginButton
import com.example.pcst_2.ui.login.RoundedCornerTextField
import com.example.pcst_2.ui.theme.BoxFilterColor
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
@Preview(showBackground = true)
fun AddArticleScreen(
    onSaved: () -> Unit = {}
) {

    val articleTitle = remember {
        mutableStateOf("")
    }
    val articleText = remember {
        mutableStateOf("")
    }
    val articleTestText = remember {
        mutableStateOf("")
    }
    val articleTestCorrect = remember {
        mutableStateOf("")
    }
    val articleTestSomeAnswer_1 = remember {
        mutableStateOf("")
    }
    val articleTestSomeAnswer_2 = remember {
        mutableStateOf("")
    }
    val articleTestSomeAnswer_3 = remember {
        mutableStateOf("")
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
        Image(
            painter = painterResource(id = R.drawable.login_logo),
            contentDescription = "logo",
            modifier = Modifier.size(90.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Add new Article",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(15.dp))
        RoundedCornerTextField(
            singleLine = false,
            maxLines = 2,
            text = articleTitle.value,
            label = "Title"
        ) {
            articleTitle.value = it
        }
        Spacer(modifier = Modifier.height(10.dp))
        RoundedCornerTextField(
            singleLine = false,
            maxLines = 2,
            text = articleText.value,
            label = "Text"
        ) {
            articleText.value = it
        }
        Spacer(modifier = Modifier.height(10.dp))
        RoundedCornerTextField(
            singleLine = false,
            maxLines = 2,
            text = articleTestText.value,
            label = "Test Text"
        ) {
            articleTestText.value = it
        }
        Spacer(modifier = Modifier.height(10.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = articleTestCorrect.value,
            label = "Correct Answer"
        ) {
            articleTestCorrect.value = it
        }
        Spacer(modifier = Modifier.height(10.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = articleTestSomeAnswer_1.value,
            label = "Some Answer 1"
        ) {
            articleTestSomeAnswer_1.value = it
        }
        Spacer(modifier = Modifier.height(10.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = articleTestSomeAnswer_2.value,
            label = "Some Answer 2"
        ) {
            articleTestSomeAnswer_2.value = it
        }
        Spacer(modifier = Modifier.height(10.dp))
        RoundedCornerTextField(
            singleLine = false,
            text = articleTestSomeAnswer_3.value,
            label = "Some Answer 3"
        ) {
            articleTestSomeAnswer_3.value = it
        }
        Spacer(modifier = Modifier.height(10.dp))

        LoginButton(text = "Save") {
            saveArticleToFireStore(
                firestore,
                Article(
                    articleTitle = articleTitle.value,
                    articleText = articleText.value,
                    articleTestText = articleTestText.value,
                    articleTestCorrect = articleTestCorrect.value,
                    articleTestSomeAnswer_1 = articleTestSomeAnswer_1.value,
                    articleTestSomeAnswer_2 = articleTestSomeAnswer_2.value,
                    articleTestSomeAnswer_3 = articleTestSomeAnswer_3.value
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
    val key = db.document().id
    db.document(key)
        .set(
            article.copy(
                key = key
            )
        )
        .addOnSuccessListener {
            onSaved()
        }
        .addOnFailureListener {
            onError()
        }
}