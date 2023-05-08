package com.example.codelab2.ui.bottomNav

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavScreen() {
    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavMenu.Home,
        BottomNavMenu.Person,
        BottomNavMenu.Notification
    )

    Scaffold(bottomBar = {
        AppBottomNavigation(navController = navController, items = bottomNavigationItems)
    }) {
        NavigationGraph(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    BottomNavScreen()
}