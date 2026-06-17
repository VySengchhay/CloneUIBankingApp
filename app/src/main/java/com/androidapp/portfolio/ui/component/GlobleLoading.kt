package com.androidapp.portfolio.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.androidapp.portfolio.R

@Composable
fun GlobleLoading() {
    Dialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
        onDismissRequest = {}
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = colorResource(R.color.black).copy(alpha = .4f)
        ) {
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
