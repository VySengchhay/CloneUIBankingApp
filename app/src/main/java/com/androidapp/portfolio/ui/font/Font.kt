package com.androidapp.mvvm.ui.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.androidapp.portfolio.R

val roboto_condensed = FontFamily(
    Font(R.font.roboto_condensed_bold, FontWeight.Bold),
    Font(R.font.roboto_condensed_medium, FontWeight.Medium),
    Font(R.font.roboto_condensed_light, FontWeight.Light)
)

val sans = FontFamily(
    Font(R.font.sans_bold, FontWeight.Bold),
    Font(R.font.sans_medium, FontWeight.Medium),
    Font((R.font.sans_normal), FontWeight.Normal)
)