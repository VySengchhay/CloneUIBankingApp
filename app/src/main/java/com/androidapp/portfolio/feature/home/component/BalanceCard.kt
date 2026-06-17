package com.androidapp.portfolio.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidapp.mvvm.ui.font.roboto_condensed
import com.androidapp.mvvm.ui.font.sans
import com.androidapp.portfolio.R

@Composable
fun BalanceCard(
    userName: String,
    typeAccount: String,
    dollarBalance: Double,
    rielBalance: Double,
    onClickShowBalance: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(top = 16.dp)
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
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 6.dp),
                text = "សួស្តី,",
                fontFamily = sans,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Text(
                text = userName,
                fontFamily = roboto_condensed,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .clip(
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(
                            color = MaterialTheme.colorScheme.secondary
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding( top = 2.dp, bottom = 2.dp, start = 8.dp, end = 8.dp),
                        text = "គណនី",
                        fontFamily = sans,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Text(
                    text = typeAccount,
                    fontFamily = sans,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.background
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier
                        .padding(end = 5.dp),
                    text = "តុល្យភាពសរុប",
                    fontFamily = sans,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                FilledIconButton(
                    onClick = {
                        onClickShowBalance()
                    },
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.background
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_eye_on),
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = "$dollarBalance $",
                    fontFamily = sans,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.background
                )

                Text(
                    text = "$rielBalance ៛",
                    fontFamily = sans,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
    }
}