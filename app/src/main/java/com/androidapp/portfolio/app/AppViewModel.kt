package com.androidapp.portfolio.app

import androidx.lifecycle.ViewModel
import com.androidapp.portfolio.naviagtion.AppState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel : ViewModel() {
    private val _state = MutableStateFlow(AppState())
    val state = _state.asStateFlow()
}