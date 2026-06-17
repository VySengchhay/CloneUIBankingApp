package com.androidapp.portfolio.utils

fun formatAccountNo(accountNo: String): String {
    return accountNo.takeLast(4).padStart(accountNo.length, '*')
}