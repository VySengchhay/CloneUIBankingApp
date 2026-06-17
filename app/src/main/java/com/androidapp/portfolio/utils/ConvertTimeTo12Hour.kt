package com.androidapp.portfolio.utils

fun convertTimeTo12Hour(time24: String): String {
    val parts = time24.split(":")
    var hour = parts[0].toInt()
    val minute = parts[1]

    val period = if (hour >= 12) "PM" else "AM"

    hour = when {
        hour == 0 -> 12
        hour > 12 -> hour - 12
        else -> hour
    }

    return "$hour:$minute $period"
}