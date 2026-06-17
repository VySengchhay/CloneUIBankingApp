package com.androidapp.portfolio.naviagtion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavKey

class AppState {
    var currentTopLevel by mutableStateOf<TopLevelDestination>(TopLevelDestination.HOME)
        private set

    private val homeBackStack = mutableStateListOf<NavKey>(Route.Home)
    private val liveChatBackStack = mutableStateListOf<NavKey>(Route.LiveChat)
    private val menuBackStack = mutableStateListOf<NavKey>(Route.Menu)

    private val currentMutableStack: MutableList<NavKey>
        get() = when (currentTopLevel) {
            TopLevelDestination.HOME -> homeBackStack
            TopLevelDestination.LIVECHAT -> liveChatBackStack
            TopLevelDestination.MENU -> menuBackStack
        }

    val currentStack: List<NavKey>
        get() = currentMutableStack

    val currentRoute: NavKey
        get() = currentMutableStack.last()

    val showBottomBar: Boolean
        get() = currentMutableStack.size == 1

    fun navigate(key: NavKey) {
        if (currentMutableStack.lastOrNull() != key) {
            currentMutableStack.add(key)
        }
    }

    fun pop() {
        val stack = currentMutableStack
        if (stack.size > 1) {
            stack.removeAt(stack.lastIndex)
        }
    }

    fun switchTopLevel(dest: TopLevelDestination) {
        currentTopLevel = dest
    }
}
