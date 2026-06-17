package com.androidapp.portfolio.naviagtion

import androidx.navigation3.runtime.NavKey

sealed interface Route: NavKey {
    data object Home : Route
    data object LiveChat : Route
    data object Menu: Route

    /**
     * Notification
     */
    data object Notification : Route


    //Feature
    // Home features
    data object Accounts : Route
    data object Cards : Route
    data object Payments : Route
    data object Scan : Route
    data object Favorites : Route
    data object Transfer : Route

    /**
     * News Feature
     */
    data object MyPoints: Route
    data object ToanchetPay: Route
    data object PublicServices: Route
    data object CSXTrade: Route
    data object CambodiaMarket: Route
    data object ExchangeRate: Route
    data object AccountSummary: Route
    data object Locator: Route
}