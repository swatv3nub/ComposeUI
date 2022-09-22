package com.example.android.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.android.composable.*

@Composable
fun MainScreen() {
    var navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navController)}) {
        BottomNavGraph(navController = navController)
        Convo(messageList = MessageData.MessageList)
    }
}


@Composable
fun Convo(messageList : List<Message>){
    LazyColumn{
        items(MessageData.MessageList){
                message -> MessageBox(message, "$message")
        }
    }
}

data class Message(val sender: String, val body:String)

private const val MINIMIZED_LINES = 2

@Composable
fun MessageBox(msg:Message, text: String){
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var textLayoutResultState = remember {
        mutableStateOf<TextLayoutResult?>(null)
    }
    var isClickable by remember {
        mutableStateOf(false)
    }
    var finalText by remember {
        mutableStateOf(text)
    }

    var textLayoutResult = textLayoutResultState.value
    LaunchedEffect(textLayoutResult) {
        if (textLayoutResult == null) return@LaunchedEffect

        when {
            isExpanded -> {
                finalText = "$text Show Less."
            }
            !isExpanded && textLayoutResult.hasVisualOverflow -> {
                val lastCharIndex = textLayoutResult.getLineEnd(MINIMIZED_LINES - 1)
                val showMoreString = "... Show More"
                val adjustedText = text
                    .substring(startIndex = 0, endIndex = lastCharIndex)
                    .dropLast(showMoreString.length)
                    .dropLastWhile { it == ' ' || it == '.' }

                finalText = "$adjustedText$showMoreString"
                isClickable = true
            }
        }
    }

    Row(modifier = Modifier.padding(all = 15.dp)) {
        Image(painter = painterResource(id = R.drawable.maskedvirus),
            contentDescription = "profilePicture",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(3.5.dp, MaterialTheme.colors.secondary, CircleShape)

        )
        Spacer(modifier = Modifier.width(25.dp))

        val primary = MaterialTheme.colors.primary
        val surface = MaterialTheme.colors.surface
        val surfaceColorChange : Color by  animateColorAsState(
            if(isExpanded) primary else surface
        )
        Column(modifier = Modifier
            .clickable/*(enabled = isClickable)*/ { isExpanded = !isExpanded }
            .animateContentSize()){
            Text(text = "${msg.sender}",
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.h1,
                fontSize = 35.sp,
                modifier = Modifier.padding(5.dp)
            )

            Spacer(modifier = Modifier
                .width(500.dp)
                .padding(bottom = 10.dp))

            Surface(shape = MaterialTheme.shapes.medium,
                elevation = 15.dp,
                color = MaterialTheme.colors.background,
                modifier = Modifier
                    .animateContentSize()
                    .padding(all = 30.dp)) {
                Text(
                    text = "${msg.body}",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(all = 10.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else MINIMIZED_LINES
                )
            }
        }
    }
}
