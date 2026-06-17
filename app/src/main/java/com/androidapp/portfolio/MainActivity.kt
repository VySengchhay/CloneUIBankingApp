package com.androidapp.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import com.androidapp.portfolio.app.App
import com.androidapp.portfolio.app.LoadingUtil
import com.androidapp.portfolio.ui.component.GlobleLoading
import com.androidapp.portfolio.ui.theme.PortfolioTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isCheck = true
        lifecycleScope.launch {
            if (isCheck) {
                delay(1000)
                isCheck = false
            }
        }
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                isCheck
            }
        }
        enableEdgeToEdge()
        setContent {
            PortfolioTheme(
                dynamicColor = false
            ) {
                if (LoadingUtil.isLoading.value) {
                    GlobleLoading()
                }
                App()
            }
        }
    }
}
