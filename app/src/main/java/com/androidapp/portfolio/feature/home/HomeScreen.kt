package com.androidapp.portfolio.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidapp.mvvm.ui.font.sans
import com.androidapp.portfolio.R
import com.androidapp.portfolio.data.models.NewsFeatureModel
import com.androidapp.portfolio.data.models.featureList
import com.androidapp.portfolio.data.models.newsFeatureList
import com.androidapp.portfolio.data.models.newsPromotionList
import com.androidapp.portfolio.feature.home.component.BalanceCard
import com.androidapp.portfolio.feature.home.component.Feature
import com.androidapp.portfolio.feature.home.component.NewsAndPromotion
import com.androidapp.portfolio.feature.home.component.NewsFeature
import kotlinx.coroutines.handleCoroutineException

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        /**
         * Balance Card
         */
        item {
            BalanceCard(
                userName = "Vy Sengchhay",
                typeAccount = "Saving",
                dollarBalance = 100.0,
                rielBalance = 1000.0,
                onClickShowBalance = {}
            )
        }

        /**
         * Feature
         */
        item {
            Feature(
                feature = featureList,
                onClickRoute = {}
            )
        }

        /**
         * News Feature
         */
        item {
            NewsFeature(
                newsFeature = newsFeatureList,
                onClickNewsFeature = { it ->
//                    println("News Feature Route $it")
                }
            )
        }

        /**
         * News and Promotion
         */
        item {
            NewsAndPromotion(
                newsAndPromotion = newsPromotionList,
                onClickNewsAndPromotion = { it ->
//                    println("News and Promotion Route $it")
                }
            )
        }
    }
}
