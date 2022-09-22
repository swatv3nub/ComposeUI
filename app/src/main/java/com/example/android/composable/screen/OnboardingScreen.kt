package com.example.android.composable.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import com.example.android.composable.R
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {
    Surface{
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Compose Camp", modifier = Modifier
                    .size(300.dp)
                //.padding(bottom = 5.dp)
                //.clip(CircleShape)
            )
            Text("Welcome to Learning Programming Language!\n \nHere you can learn the basics to advanced " +
                "level of programming in Different Languages!", textAlign = TextAlign.Center)
            /*Button(onClick = onContinueClicked,
            modifier = Modifier.padding(vertical = 24.dp)) {
                Text("Continue")
            }*/
        }
        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = onContinueClicked,
                modifier = Modifier
                    .height(60.dp)
                    .width(300.dp)
                    .padding(bottom = 5.dp)) {
                Text("Continue")
            }
        }

    }

}

