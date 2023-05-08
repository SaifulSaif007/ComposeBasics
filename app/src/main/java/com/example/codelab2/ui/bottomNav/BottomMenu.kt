package com.example.codelab2.ui.bottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavMenu(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home :
        BottomNavMenu("Home", "Home", Icons.Filled.Home)

    object Person :
        BottomNavMenu("Person", "Person", Icons.Filled.Person)

    object Notification : BottomNavMenu(
        "Notifications", "Notification", Icons.Filled.Notifications
    )

}