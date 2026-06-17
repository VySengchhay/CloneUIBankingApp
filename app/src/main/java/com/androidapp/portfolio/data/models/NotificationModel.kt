package com.androidapp.portfolio.data.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

enum class TransactionType {
    PAYMENT,
    TRANSFER,
    RECEIVED
}

enum class Currency {
    KHR, USD
}

enum class NewsCategory {
    NOTIFICATION,
    PROMOTION,
    ANNOUNCEMENT
}

data class TransactionItemModel(
    val id: String,
    val merchantName: String,
    val amount: Double,
    val currency: Currency,
    val accountNo: String,
    val date: String,
    val time: String,
    @DrawableRes val icon: Int,
    val type: TransactionType
)

data class TransactionGroup(
    val date: String,
    val transactions: List<TransactionItemModel>
)

data class BankNewsItemModel(
    val id: String,
    val date: String,
    val title: String,
    val description: String,
    @DrawableRes val imageUrl: Int,
    val category: NewsCategory
)

data class NewsGroup(
    val date: String,
    val items: List<BankNewsItemModel>
)
