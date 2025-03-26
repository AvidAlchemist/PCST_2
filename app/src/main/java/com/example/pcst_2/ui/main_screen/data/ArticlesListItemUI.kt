package com.example.pcst_2.ui.main_screen.data
//
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import coil.compose.AsyncImage
//import com.example.pcst_2.R
//import com.example.pcst_2.data.Article
//
//@Composable
//fun ArticlesListItemUI(
//    navContoller : NavHostController,
//    showEditButton: Boolean = false,
//    article: Article,
//    onEditClick: (Article) -> Unit = {}
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .border(
//                1.dp,
//                Color.Black,
//                RoundedCornerShape(15.dp),
//            ),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        AsyncImage(
//            model = R.drawable.ic_articles,
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxHeight()
//                .width(80.dp)
//                .clip(RoundedCornerShape(15.dp))
//                .padding(start = 10.dp),
//
//            contentScale = ContentScale.Crop,
//        )
//        Spacer(modifier = Modifier.width(10.dp))
//        Text(
//            text = article.articleTitle,
//            color = Color.Black,
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            modifier = Modifier
//                .align(Alignment.CenterVertically)
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .weight(1f)
//                .clickable {
//                    navContoller.navigate(
//                        ArticleTheoryScreenObject(
//                        key = article.key,
//                        title = article.title,
//                        theoryText = article.theoryText,
//                        taskTitle = article.taskTitle,
//                        taskText = article.taskText,
//                        taskTip = article.taskTip,
//                        taskCorrect = article.taskCorrect,
//                        testText = article.testText,
//                        testCorrect = article.testCorrect,
//                        testSomeAnswerOne = article.testSomeAnswerOne,
//                        testSomeAnswerTwo = article.testSomeAnswerTwo,
//                        testSomeAnswerThree = article.testSomeAnswerThree
//                    )
//                    )
//                }
//        )
//
//        if(showEditButton) IconButton(onClick = {
//            onEditClick(article)
//        }) {
//            Icon(
//                Icons.Default.Edit,
//                contentDescription = ""
//            )
//
//        }
//
//    }
