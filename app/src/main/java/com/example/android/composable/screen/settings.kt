package com.example.android.composable.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.composable.ui.theme.composableTheme

@Composable
fun Settings() {
    composableTheme() {
        Text(text = "")

    }
    
}

@Preview
@Composable
fun SettingsPreview() {
    composableTheme {
        Settings()
    }

}