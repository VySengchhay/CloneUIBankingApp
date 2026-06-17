package com.androidapp.portfolio.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidapp.mvvm.ui.font.sans
import com.androidapp.portfolio.data.models.NewsFeatureModel
import com.androidapp.portfolio.naviagtion.Route

@Composable
fun NewsFeature(
    modifier: Modifier = Modifier,
    newsFeature: List<NewsFeatureModel>,
    onClickNewsFeature: (Route) -> Unit
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.primary
            ),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        items(newsFeature.size) { index ->
            val newsFeature = newsFeature[index]

            val words = newsFeature.title.split(" ")
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(
                        onClick = {
                            onClickNewsFeature(newsFeature.route)
                        }
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .clip(
                                shape = RoundedCornerShape(16.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.background,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .background(
                                color = MaterialTheme.colorScheme.secondary
                            )
                            .padding(12.dp),
                        painter = painterResource(newsFeature.icon),
                        contentDescription = null,
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(top = 6.dp),
                    text = if (words.size == 2) {
                        words.joinToString("\n")
                    } else {
                        newsFeature.title
                    },
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.background,
                    fontFamily = sans,
                    maxLines = 2,
                )
            }
        }
    }
}
