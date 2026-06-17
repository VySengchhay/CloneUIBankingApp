package com.androidapp.portfolio.data.models

import androidx.annotation.DrawableRes
import com.androidapp.portfolio.R
import com.androidapp.portfolio.naviagtion.Route

data class FeatureModel(
    val title: String,
    @DrawableRes val icon: Int,
    val route: Route
)

val featureList: List<FeatureModel> = listOf(
    FeatureModel(
        title = "Accounts",
        icon = R.drawable.ic_account_balance_gold,
        route = Route.Accounts
    ),
    FeatureModel(
        title = "Cards",
        icon = R.drawable.ic_credit_card_gold,
        route = Route.Cards
    ),
    FeatureModel(
        title = "Payment",
        icon = R.drawable.ic_payment_gold,
        route = Route.Payments
    ),
    FeatureModel(
        title = "Scan",
        icon = R.drawable.ic_qr_scan_gold,
        route = Route.Scan
    ),
    FeatureModel(
        title = "Favorites",
        icon = R.drawable.ic_favorites_gold,
        route = Route.Favorites
    ),
    FeatureModel(
        title = "Transfer",
        icon = R.drawable.ic_transfer_gold,
        route = Route.Transfer
    )
)
