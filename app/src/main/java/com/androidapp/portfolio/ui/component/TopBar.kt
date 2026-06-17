package com.androidapp.portfolio.ui.component

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.androidapp.mvvm.ui.font.sans
import com.androidapp.portfolio.R
import com.androidapp.portfolio.naviagtion.Route
import com.androidapp.portfolio.naviagtion.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    key: NavKey,
    canGoBack: Boolean,
    onBack: () -> Unit,
    onClickNotification: () -> Unit,
    onClickScanQR: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = when (key) {
                    Route.Home -> stringResource(R.string.lbl_company_name)
                    Route.LiveChat -> "LiveChat"
                    Route.Menu -> "Menu"
                    Route.Notification -> "Notification"
                    else -> ""
                },
                fontSize = 22.sp,
                fontFamily = sans,
                fontWeight = FontWeight.Medium
            )
        },
        navigationIcon = {
            if (canGoBack) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            } else {
                if (key == Route.Home) {
                     IconButton(
                            onClick = {},
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = null
                            )
                        }
                }
            }
        },
        actions = {
            if (key == Route.Home) {
                if (!canGoBack) {
                    IconButton(onClick = { onClickNotification() }) {
                        BadgedBox(
                            badge = {
                                Badge()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = null
                            )
                        }
                    }
                    IconButton(
                        onClick = { onClickScanQR() }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_qr_scan_gold),
                            contentDescription = null
                        )
                    }
                } else null
            } else if (key == Route.Menu) {
                IconButton(
                    onClick = {}
                ) {
                    Image(
                        painter = painterResource(R.drawable.im_vbc_logo),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.background,
            navigationIconContentColor = MaterialTheme.colorScheme.secondary,
            actionIconContentColor = MaterialTheme.colorScheme.secondary
        )
    )
}
