package com.example.android.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    var route: String,
    var title: String,
    var icon: ImageVector
) {
    object Python : BottomBarScreen(
        route = "python",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Rust : BottomBarScreen(
        route = "rust",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object Kotlin : BottomBarScreen(
        route = "kotlin",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}
