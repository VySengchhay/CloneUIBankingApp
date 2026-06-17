package com.androidapp.portfolio.feature.home.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidapp.mvvm.ui.font.roboto_condensed
import com.androidapp.mvvm.ui.font.sans
import com.androidapp.portfolio.R
import com.androidapp.portfolio.app.BaseUiState
import com.androidapp.portfolio.app.LoadingUtil
import com.androidapp.portfolio.utils.convertTimeTo12Hour
import com.androidapp.portfolio.utils.formatAccountNo
import com.androidapp.portfolio.utils.formatCurrency
import com.androidapp.portfolio.utils.formatDate

@Composable
fun Notification(
    notificationViewModel: NotificationViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val transactionState = notificationViewModel.transactionList.collectAsStateWithLifecycle().value
    val newsState = notificationViewModel.newsList.collectAsStateWithLifecycle().value

    val segOptions = listOf("ដំណឹងសំខាន់", "ប្រតិបត្តិការ", "សារជូនដំណឹង")
    var selectedTap by remember { mutableStateOf(0) }
    val segSelectedIndex = notificationViewModel.selectedTab

    LaunchedEffect(transactionState) {
        when (transactionState) {
            is BaseUiState.Loading, BaseUiState.None -> LoadingUtil.showLoading()
            is BaseUiState.Success<*> -> LoadingUtil.hideLoading()
            is BaseUiState.Error -> LoadingUtil.hideLoading()
            else -> {}
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        when (transactionState) {

            BaseUiState.None -> {}

            is BaseUiState.Loading -> {
                // Loading UI if needed
            }

            is BaseUiState.Error -> {
                Text(
                    text = transactionState.message,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is BaseUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                        ) {
                            SingleChoiceSegmentedButtonRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(
                                        shape = RoundedCornerShape(60.dp)
                                    )
                                    .background(
                                        color = MaterialTheme.colorScheme.primary
                                    ),
                            ) {
                                segOptions.forEachIndexed { index, label ->
                                    SegmentedButton(
                                        modifier = Modifier.padding(
                                            start = 5.dp,
                                            top = 2.dp,
                                            end = 5.dp,
                                            bottom = 2.dp
                                        ),
                                        selected = index == selectedTap,
                                        onClick = {
                                            selectedTap = index
//                                            notificationViewModel.onTabSelected(index)
                                        },
                                        icon = {},
                                        shape = if (index == selectedTap) {
                                            RoundedCornerShape(60) // fully rounded (pill)
                                        } else {
                                            SegmentedButtonDefaults.itemShape(
                                                index = index, count = segOptions.size
                                            )
                                        },
                                        label = {
                                            Text(
                                                text = label,
                                                fontFamily = sans,
                                                fontWeight = FontWeight.Medium,
                                                fontSize = 16.sp
                                            )
                                        },
                                        colors = SegmentedButtonDefaults.colors(
                                            activeContainerColor = MaterialTheme.colorScheme.surface,
                                            activeContentColor = MaterialTheme.colorScheme.onSurface,
                                            inactiveContainerColor = MaterialTheme.colorScheme.primary,
                                            inactiveContentColor = MaterialTheme.colorScheme.surface
                                        ),
                                        border = SegmentedButtonDefaults.borderStroke(
                                            width = 0.dp,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                }
                            }

                            when (selectedTap) {
                                0 -> {
                                    Column(
                                        modifier = Modifier
                                            .fillParentMaxSize()
                                            .padding(horizontal = 8.dp),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            modifier = Modifier.size(
                                                height = 70.dp, width = 70.dp
                                            ),
                                            painter = painterResource(R.drawable.ic_public_services),
                                            contentDescription = "Icon notification",
                                            colorFilter = ColorFilter.tint(
                                                MaterialTheme.colorScheme.onSurface.copy(alpha = .62f)
                                            )
                                        )
                                        Text(
                                            modifier = Modifier.padding(vertical = 10.dp),
                                            text = "មិនមានសារជូនដំណឹង",
                                            fontSize = 24.sp,
                                            fontFamily = sans,
                                            fontWeight = FontWeight.Medium,
                                            color = MaterialTheme.colorScheme.onSurface,
                                        )
                                        Text(
                                            text = "អ្នកមិនទាន់មានសារជូនដំណឹងនៅត្រង់នេះទេ",
                                            fontSize = 16.sp,
                                            fontFamily = sans,
                                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .62f),
                                        )
                                    }
                                }

                                1 -> {
                                    transactionState.data.forEach { (date, transactions) ->
                                        Column(
                                            modifier = Modifier
                                                .padding(horizontal = 8.dp)
                                                .padding(top = 15.dp)
                                                .fillMaxSize(),
                                        ) {
                                            Text(
                                                modifier = Modifier
                                                    .padding(bottom = 10.dp),
                                                text = formatDate(date),
                                                fontFamily = sans,
                                                fontWeight = FontWeight.Medium,
                                                fontSize = 18.sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )

                                            transactions.forEach { transaction ->
                                                Card(
                                                    modifier = Modifier
                                                        .padding(vertical = 8.dp)
                                                        .fillMaxWidth()
                                                        .height(100.dp),
                                                    colors = CardDefaults.cardColors(
                                                        containerColor = MaterialTheme.colorScheme.surface
                                                    )
                                                ) {
                                                    Row(
                                                        modifier = Modifier
                                                            .padding(14.dp)
                                                            .fillMaxSize()
                                                    ) {
                                                        Image(
                                                            modifier = Modifier
                                                                .size(50.dp)
                                                                .clip(
                                                                    shape = CircleShape
                                                                )
                                                                .background(
                                                                    color = MaterialTheme.colorScheme.onSurface
                                                                )
                                                                .border(
                                                                    width = 2.dp,
                                                                    color = Color.Black,
                                                                    shape = CircleShape
                                                                ),
                                                            contentScale = ContentScale.Crop,
                                                            painter = painterResource(transaction.icon),
                                                            contentDescription = "logo"
                                                        )

                                                        Column(
                                                            modifier = Modifier
                                                                .fillMaxSize()
                                                                .padding(start = 14.dp)
                                                        ) {
                                                            Row(
                                                                modifier = Modifier
                                                                    .fillMaxWidth()
                                                                    .height(22.dp),
                                                                verticalAlignment = Alignment.Bottom,
                                                                horizontalArrangement = Arrangement.SpaceBetween
                                                            ) {
                                                                Text(
                                                                    text = transaction.merchantName.uppercase(),
                                                                    fontFamily = sans,
                                                                    fontSize = 18.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    color = MaterialTheme.colorScheme.onSurface
                                                                )
                                                                Text(
                                                                    text = convertTimeTo12Hour(transaction.time),
                                                                    fontFamily = sans,
                                                                    fontSize = 16.sp,
                                                                    fontWeight = FontWeight.Normal,
                                                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .62f)
                                                                )
                                                            }

                                                            Row(
                                                                modifier = Modifier
                                                                    .fillMaxWidth()
                                                                    .padding(top = 16.dp),
                                                                verticalAlignment = Alignment.CenterVertically,
                                                                horizontalArrangement = Arrangement.spacedBy(5.dp)
                                                            ) {
                                                                Text(
                                                                    text = formatCurrency(transaction.amount, transaction.currency),
                                                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .8f),
                                                                    fontFamily = roboto_condensed,
                                                                    fontWeight = FontWeight.Medium,
                                                                    fontSize = 15.sp
                                                                )
                                                                Text(
                                                                    text = "បានទូទាត់ពីគណនី",
                                                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .8f),
                                                                    fontFamily = roboto_condensed,
                                                                    fontWeight = FontWeight.Medium,
                                                                    fontSize = 15.sp
                                                                )
                                                                Text(
                                                                    text = formatAccountNo(transaction.accountNo),
                                                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .8f),
                                                                    fontFamily = roboto_condensed,
                                                                    fontWeight = FontWeight.Medium,
                                                                    fontSize = 15.sp
                                                                )

                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                2 -> {
                                    val newsGroups = (newsState as? BaseUiState.Success)?.data.orEmpty()
                                    newsGroups.forEach { (date, items) ->
                                        Column(
                                            modifier = Modifier
                                                .padding(horizontal = 8.dp)
                                                .padding(top = 15.dp)
                                                .fillMaxSize(),
                                        ) {
                                            Text(
                                                modifier = Modifier
                                                    .padding(bottom = 10.dp),
                                                text = formatDate(date),
                                                fontFamily = sans,
                                                fontWeight = FontWeight.Medium,
                                                fontSize = 18.sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )

                                            items.forEach { newsItem ->
                                                Box(
                                                    modifier = Modifier
                                                        .padding(vertical = 8.dp)
                                                        .fillMaxWidth()
                                                        .height(130.dp)
                                                        .clip(
                                                            shape = RoundedCornerShape(16.dp)
                                                        )
                                                        .background(
                                                            color = MaterialTheme.colorScheme.surface
                                                        )
                                                ) {
                                                    Image(
                                                        modifier = Modifier.scale(1.4f),
                                                        painter = painterResource(newsItem.imageUrl),
                                                        contentDescription = "image notification",
                                                        contentScale = ContentScale.FillWidth
                                                    )

                                                    Column(
                                                        modifier = Modifier.fillMaxSize(),
                                                        verticalArrangement = Arrangement.Bottom
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .height(65.dp)
                                                                .clip(
                                                                    shape = RoundedCornerShape(
                                                                        0.dp, 0.dp, 16.dp, 16.dp
                                                                    )
                                                                )
                                                                .background(
                                                                    brush = Brush.verticalGradient(
                                                                        colors = listOf(
                                                                            Color.Transparent, // no color
                                                                            Color.Black       // fade to black
                                                                        )
                                                                    )
                                                                )
                                                        )
                                                    }

                                                    Column(
                                                        modifier = Modifier
                                                            .padding(horizontal = 20.dp)
                                                            .padding(bottom = 10.dp)
                                                            .fillMaxSize(),
                                                        verticalArrangement = Arrangement.Bottom
                                                    ) {
                                                        Text(
                                                            text = newsItem.title,
                                                            fontSize = 19.sp,
                                                            color = MaterialTheme.colorScheme.surface,
                                                            fontFamily = sans,
                                                            fontWeight = FontWeight.Bold
                                                        )

                                                        Spacer(modifier = Modifier.height(3.dp))

                                                        Text(
                                                            text = newsItem.description,
                                                            maxLines = 1,
                                                            overflow = TextOverflow.Ellipsis,
                                                            color = MaterialTheme.colorScheme.surface.copy(alpha = .82f),
                                                            fontFamily = sans,
                                                            fontWeight = FontWeight.Medium,
                                                            fontSize = 16.sp
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else -> {}
        }
    }

}
