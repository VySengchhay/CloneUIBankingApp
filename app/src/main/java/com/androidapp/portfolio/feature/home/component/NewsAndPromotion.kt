package com.androidapp.portfolio.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidapp.mvvm.ui.font.sans
import com.androidapp.portfolio.data.models.NewsPromotionModel
import com.androidapp.portfolio.data.models.newsPromotionList
import com.androidapp.portfolio.naviagtion.Route

@Composable
fun NewsAndPromotion(
    modifier: Modifier = Modifier,
    newsAndPromotion: List<NewsPromotionModel>,
    onClickNewsAndPromotion: (Route) -> Unit
) {
    val pagerState = rememberPagerState { newsPromotionList.size }

    Column(
        modifier = modifier
            .padding(vertical = 16.dp)
            .clickable(
                onClick = {}
            )
    ) {
        Text(
            text = "News & Promotion",
            fontFamily = sans,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.background,
            fontWeight = FontWeight.Medium
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(16.dp)
                )
                .height(200.dp)
                .padding(vertical = 16.dp),
            pageSpacing = 16.dp,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentScale = ContentScale.Crop,
                painter = painterResource(newsPromotionList[it].image),
                contentDescription = null
            )
        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(4.dp)
                )
            }
        }
    }
}
