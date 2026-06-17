package com.androidapp.portfolio.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.androidapp.portfolio.data.models.bottomNavItems
import com.androidapp.portfolio.naviagtion.TopLevelDestination

@Composable
fun BottomBar(
    current: TopLevelDestination,
    onSelect: (TopLevelDestination) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = current == item.destination,
                onClick = { onSelect(item.destination) },
                icon = { Icon(item.icon, null) },
                label = { Text(item.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.background,
                    selectedTextColor = MaterialTheme.colorScheme.background,
                    unselectedIconColor = MaterialTheme.colorScheme.secondary,
                    unselectedTextColor = MaterialTheme.colorScheme.secondary,
                    indicatorColor = MaterialTheme.colorScheme.secondary,
                )
            )
        }
    }
}