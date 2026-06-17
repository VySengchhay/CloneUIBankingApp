package com.androidapp.portfolio.feature.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidapp.mvvm.ui.font.sans
import com.androidapp.portfolio.R
import com.androidapp.portfolio.data.models.menuList

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.primary
            ),
    ) {
        item {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = MaterialTheme.colorScheme.primary
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(
                                shape = CircleShape
                            ),
                        painter = painterResource(R.drawable.im_profile),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = "Vy Sengchhay".uppercase(),
                            fontFamily = sans,
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.background,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "098 966 166",
                            fontFamily = sans,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.background,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.primary
                        )
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FilledTonalButton(
                        modifier = Modifier
                            .size(width = 180.dp, height = 48.dp),
                        onClick = {},
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.background
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_edit),
                                contentDescription = null
                            )
                            Text(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                text = "Edit_Profile",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = sans
                            )
                        }
                    }
                    FilledTonalButton(
                        modifier = Modifier
                            .size(width = 180.dp, height = 48.dp),
                        onClick = {},
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.background
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_setting),
                                contentDescription = null
                            )
                            Text(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                text = "Settings",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = sans
                            )
                        }
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .background(
                        color = MaterialTheme.colorScheme.secondary
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .clip(
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(
                            color = MaterialTheme.colorScheme.background
                        )
                ) {
                    menuList.forEach { menu ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 6.dp)
                                .clickable(
                                    onClick = {}
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            FilledIconButton(
                                onClick = {},
                                colors = IconButtonDefaults.filledIconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.secondary,
                                )
                            ) {
                               Icon(
                                   painter = painterResource(menu.icon),
                                   contentDescription = null,
                                   tint = MaterialTheme.colorScheme.background
                               )
                            }

                            Text(
                                modifier = Modifier
                                    .padding(start = 12.dp),
                                text = menu.title,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = sans,
                                color = MaterialTheme.colorScheme.secondary
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Icon(
                                modifier = Modifier
                                    .size(16.dp),
                                painter = painterResource(R.drawable.ic_arrow_forward),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.outline
                            )
                        }

                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                        .background(
                            color = MaterialTheme.colorScheme.secondary
                        ),
//                verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .padding(bottom = 3.dp),
                        text = "Version 1.00",
                        fontSize = 16.sp,
                        fontFamily = sans,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.outline
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 3.dp),
                        text = "Released Date: June 06, 2026",
                        fontSize = 16.sp,
                        fontFamily = sans,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.outline
                    )
                    Text(
                        modifier = Modifier
                            .padding(6.dp),
                        text = "Your VBC mobile version is up to date",
                        fontSize = 16.sp,
                        fontFamily = sans,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.outline
                    )

                    Text(
                        modifier = Modifier
                            .padding(6.dp),
                        text = "Vy Bank Plc. - Credentials",
                        fontSize = 16.sp,
                        fontFamily = sans,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }
}
