package com.example.android.composable.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.composable.ui.theme.composableTheme

@Composable
fun Kotlin() {
    composableTheme() {
        Text(text = "")

    }
    
}

@Preview
@Composable
fun KotlinPreview() {
    composableTheme() {
        Text(text = "")

    }

}