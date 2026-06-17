package com.androidapp.portfolio.utils

import com.androidapp.portfolio.data.models.Currency

fun formatCurrency(amount: Double, currency: Currency): String {
    return when (currency) {
        Currency.KHR -> "${amount.toInt()} KHR"
        Currency.USD -> "$${"%.2f".format(amount)}"
    }
}
