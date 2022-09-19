package com.example.android.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android.composable.screen.Kotlin
import com.example.android.composable.screen.Python
import com.example.android.composable.screen.Rust


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Python.route
    ) {
        composable(route = BottomBarScreen.Python.route) {
            Python()
        }
        composable(route = BottomBarScreen.Rust.route) {
            Rust()
        }
        composable(route = BottomBarScreen.Kotlin.route) {
            Kotlin()
        }
    }
}