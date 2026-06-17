package com.androidapp.portfolio.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun formatDate(input: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH)

    val date = LocalDate.parse(input, inputFormatter)
    return date.format(outputFormatter).uppercase()
}