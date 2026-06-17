package com.androidapp.portfolio.naviagtion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.androidapp.portfolio.feature.home.HomeScreen
import com.androidapp.portfolio.feature.home.notification.Notification
import com.androidapp.portfolio.feature.menu.MenuScreen
import com.androidapp.portfolio.ui.component.BottomBar
import com.androidapp.portfolio.ui.component.TopBar

@Composable
fun NavigationRoot(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    val currentTopLevel = appState.currentRoute
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .navigationBarsPadding(),
        topBar = {
            TopBar(
                key = currentTopLevel,
                canGoBack = appState.currentStack.size > 1,
                onClickNotification = { appState.navigate(Route.Notification) },
                onClickScanQR = {},
                onBack = appState::pop
            )
        },
        bottomBar = {
            if (appState.showBottomBar) {
                BottomBar(
                    current = appState.currentTopLevel,
                    onSelect = appState::switchTopLevel
                )
            }
        }
    ) { paddingValues ->
        NavDisplay(
            modifier = Modifier
                .padding(paddingValues)
                .background(
                    color = MaterialTheme.colorScheme.secondary
                ),
            backStack = appState.currentStack,
            onBack = appState::pop,
            entryProvider = entryProvider {
                entry<Route.Home> {
                    HomeScreen()
                }

                entry<Route.Notification> {
                    Notification()
                }

                entry<Route.LiveChat> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("LiveChat")
                    }
                }

                entry<Route.Menu> {
                    MenuScreen()
                }
            }
        )
    }
}
