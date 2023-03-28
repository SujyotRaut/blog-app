package com.example.blogapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blogapp.ui.screens.AuthScreen
import com.example.blogapp.ui.screens.BlogScreen
import com.example.blogapp.ui.screens.HomeScreen

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home")
    object AuthScreen: Screen("auth")
    object BlogScreen: Screen("blog")
}

@Composable
fun Navigation(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = Screen.HomeScreen.route
) {
    NavHost(navController = navHostController, startDestination = startDestination) {

        composable(Screen.HomeScreen.route) {
            HomeScreen(
                onNavigateToBlogScreen = { navHostController.navigate(Screen.BlogScreen.route)}
            )
        }

        composable(Screen.AuthScreen.route) {
            AuthScreen(
                onNavigateToHomeScreen = { navHostController.navigate(Screen.HomeScreen.route) }
            )
        }

        composable(Screen.BlogScreen.route) { BlogScreen() }
    }
}