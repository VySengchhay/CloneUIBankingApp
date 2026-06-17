package com.androidapp.portfolio.data.models

import androidx.annotation.DrawableRes
import com.androidapp.portfolio.R

data class NewsPromotionModel (
    val id: Int,
    @DrawableRes val image: Int,
)

val newsPromotionList: List<NewsPromotionModel> = listOf(
    NewsPromotionModel(
        id = 1,
        image = R.drawable.im_noti1
    ),
    NewsPromotionModel(
        id = 2,
        image = R.drawable.im_noti2
    ),
    NewsPromotionModel(
        id = 3,
        image = R.drawable.im_noti3
    ),
    NewsPromotionModel(
        id = 4,
        image = R.drawable.im_noti4
    ),
    NewsPromotionModel(
        id = 5,
        image = R.drawable.im_noti5
    ),
    NewsPromotionModel(
        id = 6,
        image = R.drawable.im_noti6
    ),
)