package com.androidapp.portfolio.data.models

import androidx.annotation.DrawableRes
import com.androidapp.portfolio.R
import com.androidapp.portfolio.naviagtion.Route

data class NewsFeatureModel (
    val title: String,
    @DrawableRes val icon: Int,
    val route: Route
)

val newsFeatureList: List<NewsFeatureModel> = listOf(
    NewsFeatureModel(
        title = "My Points",
        icon = R.drawable.ic_payment,
        route = Route.MyPoints
    ),
    NewsFeatureModel(
        title = "Toanchet Pay",
        icon = R.drawable.ic_tonchet_pay,
        route = Route.ToanchetPay
    ),
    NewsFeatureModel(
        title = "Public Services",
        icon = R.drawable.ic_public_services,
        route = Route.PublicServices
    ),
    NewsFeatureModel(
        title = "CSX Trade",
        icon = R.drawable.ic_csx_trade,
        route = Route.CSXTrade
    ),
    NewsFeatureModel(
        title = "Cambodia Market",
        icon = R.drawable.ic_cam_market,
        route = Route.CambodiaMarket
    ),
    NewsFeatureModel(
        title = "Exchange Rate",
        icon = R.drawable.ic_exchange_rate,
        route = Route.ExchangeRate
    ),
    NewsFeatureModel(
        title = "Account Summary",
        icon = R.drawable.ic_acc_summary,
        route = Route.AccountSummary
    ),
    NewsFeatureModel(
        title = "Locator",
        icon = R.drawable.ic_locator,
        route = Route.Locator
    )
)
