package com.androidapp.portfolio.app

import androidx.compose.runtime.mutableStateOf

/**
 * Singleton
 */
object LoadingUtil {
    private var _isLoading = mutableStateOf(false)
    val isLoading = _isLoading

    fun showLoading() {
        _isLoading.value = true
    }

    fun hideLoading() {
        _isLoading.value = false
    }
}
