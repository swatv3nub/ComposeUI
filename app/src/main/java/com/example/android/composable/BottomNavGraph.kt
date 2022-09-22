package com.example.android.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android.composable.screen.Profile
import com.example.android.composable.MainScreen
import com.example.android.composable.screen.Settings


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.MainScreen.route
    ) {
        composable(route = BottomBarScreen.MainScreen.route) {
            //MainScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            Profile()
        }
        composable(route = BottomBarScreen.Settings.route) {
            Settings()
        }
    }
}