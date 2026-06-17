package com.androidapp.portfolio.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidapp.portfolio.naviagtion.NavigationRoot

@Composable
fun App(
    appViewModel: AppViewModel = viewModel()
) {
    val appState by appViewModel.state.collectAsStateWithLifecycle()

    NavigationRoot(
        appState = appState
    )
}