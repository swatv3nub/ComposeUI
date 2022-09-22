package com.example.android.composable

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

import com.example.android.composable.ui.theme.composableTheme
import com.example.android.composable.screen.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            composableTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    var showOnboarding by remember {
        mutableStateOf(true)
    }
    if (showOnboarding) {
        OnboardingScreen(onContinueClicked = { showOnboarding = false})
    } else {
        MainScreen()
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = false,
    name = "UI Formation - Dark Mode",
    widthDp = 420)
@Composable
fun PreviewMessageBox() {
    composableTheme {
        MainApp()
    }
}

/*@Preview(name = "UI Formation - Light Mode",
showBackground = true)
@Composable
fun PreviewMessageBoox(){
    composableTheme() {
        Convo(messageList = MessageData.MessageList)
    }
}*/

