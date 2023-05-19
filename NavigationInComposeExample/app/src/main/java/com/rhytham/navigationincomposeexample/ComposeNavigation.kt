package com.rhytham.navigationincomposeexample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "first_screen"
    ) {
        composable("first_screen") {
            FirstScreen(navController = navController)
        }
        composable("second_screen") {
            SecondScreen(navController = navController)
        }
        composable("third_screen") {
            ThirdScreen()
        }
    }
}