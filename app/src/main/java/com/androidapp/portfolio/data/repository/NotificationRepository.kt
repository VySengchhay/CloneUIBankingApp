package com.androidapp.portfolio.data.repository

import androidx.compose.ui.res.painterResource
import com.androidapp.portfolio.R
import com.androidapp.portfolio.data.models.BankNewsItemModel
import com.androidapp.portfolio.data.models.Currency
import com.androidapp.portfolio.data.models.NewsCategory
import com.androidapp.portfolio.data.models.NewsGroup
import com.androidapp.portfolio.data.models.TransactionGroup
import com.androidapp.portfolio.data.models.TransactionItemModel
import com.androidapp.portfolio.data.models.TransactionType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NotificationRepository {
    val transactionList = listOf(
        TransactionItemModel(
            id = "1",
            merchantName = "COFFEE BRIDGE IFL",
            amount = 13500.0,
            currency = Currency.KHR,
            accountNo = "001717639",
            date = "20260422",
            time = "13:32",
            icon = R.drawable.logo_kfc,
            type = TransactionType.PAYMENT
        ),
        TransactionItemModel(
            id = "2",
            merchantName = "ROASTDALY",
            amount = 9000.0,
            currency = Currency.KHR,
            accountNo = "001717639",
            date = "20260422",
            time = "12:21",
            icon = R.drawable.logo_starbucks,
            type = TransactionType.PAYMENT
        ),
        TransactionItemModel(
            id = "3",
            merchantName = "LY CHHAINY",
            amount = 6.5,
            currency = Currency.USD,
            accountNo = "001717639",
            date = "20260422",
            time = "7:26",
            icon = R.drawable.logo_tube_coffee,
            type = TransactionType.TRANSFER
        ),
        TransactionItemModel(
            id = "4",
            merchantName = "BUN SOPANHA",
            amount = 8500.0,
            currency = Currency.KHR,
            accountNo = "001717639",
            date = "20260315",
            time = "12:13",
            icon = R.drawable.logo_starbucks,
            type = TransactionType.TRANSFER
        ),
        TransactionItemModel(
            id = "5",
            merchantName = "Amazon",
            amount = 25.99,
            currency = Currency.USD,
            accountNo = "001717639",
            date = "20260310",
            time = "9:45",
            icon = R.drawable.logo_kfc,
            type = TransactionType.PAYMENT
        ),
        TransactionItemModel(
            id = "6",
            merchantName = "Salary",
            amount = 1200.0,
            currency = Currency.USD,
            accountNo = "001717639",
            date = "20260312",
            time = "8:00",
            icon = R.drawable.logo_starbucks,
            type = TransactionType.RECEIVED
        ),
        TransactionItemModel(
            id = "7",
            merchantName = "Electricity Bill",
            amount = 45000.0,
            currency = Currency.KHR,
            accountNo = "001717639",
            date = "20260301",
            time = "18:30",
            icon = R.drawable.logo_starbucks,
            type = TransactionType.PAYMENT
        ),
        TransactionItemModel(
            id = "8",
            merchantName = "Water Utility",
            amount = 12000.0,
            currency = Currency.KHR,
            accountNo = "001717639",
            date = "20260301",
            time = "05:10",
            icon = R.drawable.logo_tube_coffee,
            type = TransactionType.PAYMENT
        ),
        TransactionItemModel(
            id = "9",
            merchantName = "Friend Transfer",
            amount = 50.0,
            currency = Currency.USD,
            accountNo = "001717639",
            date = "20251231",
            time = "22:15",
            icon = R.drawable.logo_starbucks,
            type = TransactionType.RECEIVED
        ),
        TransactionItemModel(
            id = "10",
            merchantName = "Grab Ride",
            amount = 3.75,
            currency = Currency.USD,
            accountNo = "001717639",
            date = "20251231",
            time = "13:05",
            icon = R.drawable.logo_starbucks,
            type = TransactionType.PAYMENT
        )
    )

    val transactionGroupList = transactionList
        .groupBy { it.date } // 🔥 group by date
        .map { (date, transactions) ->
            TransactionGroup(
                date = date,
                transactions = transactions
            )
        }
        .sortedByDescending { it.date } // optional: latest first

    val newsList = listOf(
        BankNewsItemModel(
            id = "1",
            date = "20260422",
            title = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?1",
            description = "ABA បន្តគាំទ្រអាជីវកម្មក្នុងស្រុកទូទាំងប្រទេសកម្ពុជា! ក្នុងនាមជាអ្នកឧបត្ថម្ភ Gold Sponsor នៃពិព័រណ៍ផលិតផលខ្មែរ 2026 រៀបចំឡើងដោយសម្ព័ន្ធសមាគមសហគ្រាសធុនតូច និងមធ្យមកម្ពុជា (FASMEC) ធនាគារ ABA មានមោទនភាពក្នុងការចូលរួមជាមួយសហគ្រាសក្នុងស្រុកជាង ៣០០ ដើម្បីបង្ហាញផលិតផលខ្មែរ និងលើកកម្ពស់ការគាំទ្រយ៉ាងទូលំទូលាយចំពោះម៉ាកសញ្ញាផលិតផលក្នុងស្រុក។",
            imageUrl = R.drawable.im_noti1,
            category = NewsCategory.ANNOUNCEMENT
        ),
        BankNewsItemModel(
            id = "2",
            date = "20260422",
            title = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?2",
            description = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?2",
            imageUrl = R.drawable.im_noti2,
            category = NewsCategory.ANNOUNCEMENT
        ),
        BankNewsItemModel(
            id = "3",
            date = "20260315",
            title = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?3",
            description = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?3",
            imageUrl = R.drawable.im_noti3,
            category = NewsCategory.NOTIFICATION
        ),
        BankNewsItemModel(
            id = "4",
            date = "20260310",
            title = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?4",
            description = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?4",
            imageUrl = R.drawable.im_noti4,
            category = NewsCategory.PROMOTION
        ),
        BankNewsItemModel(
            id = "5",
            date = "20260301",
            title = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?5",
            description = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?5",
            imageUrl = R.drawable.im_noti5,
            category = NewsCategory.PROMOTION
        ),BankNewsItemModel(
            id = "6",
            date = "20251231",
            title = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?6",
            description = "ឆ្នាំនេះ ចូលឆ្នាំនៅភ្នំពេញ?6",
            imageUrl = R.drawable.im_noti6,
            category = NewsCategory.NOTIFICATION
        ),
    )

    val newsGroupList = newsList
        .groupBy { it.date } // 🔥 group by date
        .map { (date, items) ->
            NewsGroup(
                date = date,
                items = items
            )
        }
        .sortedByDescending { it.date } // optional: latest first

    suspend fun getNotificationTransactionList() : Flow<List<TransactionGroup>> {
        delay(300)
        return flow {
            emit(transactionGroupList)
        }
    }

    suspend fun getNotificationNewsList() : Flow<List<NewsGroup>> {
        delay(300)
        return flow {
            emit(newsGroupList)
        }
    }
}
