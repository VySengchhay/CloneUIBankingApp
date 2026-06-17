package com.androidapp.portfolio.data.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.androidapp.portfolio.naviagtion.TopLevelDestination

data class BottomNavItem (
    val destination: TopLevelDestination,
    val title: String,
    val icon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem(
        destination = TopLevelDestination.HOME,
        title = "Home",
        icon = Icons.Default.Home,
    ),
    BottomNavItem(
        destination = TopLevelDestination.LIVECHAT,
        title = "LiveChat",
        icon = Icons.Filled.MailOutline,
    ),
    BottomNavItem(
        destination = TopLevelDestination.MENU,
        title = "Menu",
        icon = Icons.Default.Menu,
    ),
)