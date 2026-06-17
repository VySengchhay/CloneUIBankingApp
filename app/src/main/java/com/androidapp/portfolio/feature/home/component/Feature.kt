package com.androidapp.portfolio.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.androidapp.mvvm.ui.font.sans
import com.androidapp.portfolio.R
import com.androidapp.portfolio.data.models.FeatureModel
import com.androidapp.portfolio.naviagtion.Route

@Composable
fun Feature(
    feature: List<FeatureModel>,
    onClickRoute: (Route) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .height(215.dp)
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        userScrollEnabled = false
    ) {
        items (feature.size) { index ->
            val feature = feature[index]
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(
                        color = MaterialTheme.colorScheme.primary
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
                    .clickable(
                        onClick = {
                            onClickRoute(feature.route)
                        }
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(feature.icon),
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier
                        .padding(top = 6.dp),
                    text = feature.title,
                    fontFamily = sans,
                    color = MaterialTheme.colorScheme.background,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
