package com.example.codelab2.ui.bottomNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavMenu.Home.route) {
        composable(route = BottomNavMenu.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavMenu.Person.route) {
            PersonScreen()
        }
        composable(route = BottomNavMenu.Notification.route) {
            NotificationScreen()
        }
    }
}