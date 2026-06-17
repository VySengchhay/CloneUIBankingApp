package com.androidapp.portfolio.data.models

import androidx.annotation.DrawableRes
import com.androidapp.portfolio.R

data class MenuModel(
    val title: String,
    @DrawableRes val icon: Int
)

val menuList: List<MenuModel> = listOf(
    MenuModel(
        title = "Language",
        icon = R.drawable.ic_language
    ),
    MenuModel(
        title = "Accounts",
        icon = R.drawable.ic_account_balance
    ),
    MenuModel(
        title = "Cards",
        icon = R.drawable.ic_credit_card
    ),
    MenuModel(
        title = "Payment",
        icon = R.drawable.ic_payment
    ),
    MenuModel(
        title = "Transfer",
        icon = R.drawable.ic_transfer
    ),
    MenuModel(
        title = "Scan",
        icon = R.drawable.ic_qr_scan
    ),
    MenuModel(
        title = "Favorites",
        icon = R.drawable.ic_feature_favourite
    ),
    MenuModel(
        title = "My Points",
        icon = R.drawable.ic_payment
    ),
    MenuModel(
        title = "Toanchet Pay",
        icon = R.drawable.ic_tonchet_pay
    ),
    MenuModel(
        title = "Public Services",
        icon = R.drawable.ic_public_services
    ),
    MenuModel(
        title = "CSX Trade",
        icon = R.drawable.ic_csx_trade
    ),
    MenuModel(
        title = "Cambodia Market",
        icon = R.drawable.ic_cam_market
    ),
    MenuModel(
        title = "Exchange Rate",
        icon = R.drawable.ic_exchange_rate
    ),
    MenuModel(
        title = "Account Summary",
        icon = R.drawable.ic_acc_summary
    ),
    MenuModel(
        title = "Locator",
        icon = R.drawable.ic_locator
    ),
    MenuModel(
        title = "Settings",
        icon = R.drawable.ic_setting
    )
)
