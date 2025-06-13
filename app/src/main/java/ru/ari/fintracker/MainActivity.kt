package ru.ari.fintracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.ari.fintracker.ui.theme.FinTrackerTheme
import ru.ari.navigation.AppBottomBar
import ru.ari.navigation.AppNavGraph
import ru.ari.navigation.NavigationItem
import ru.ari.navigation.getRouteTitleId
import ru.ari.navigation.getRouteTrailingIconId
import ru.ari.ui.components.CustomTopAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val fabRoutes = NavigationItem.getRoutesWithFloatingButton()
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route
            val isActionButtonVisible = currentRoute in fabRoutes

            FinTrackerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.surface,
                    topBar = {
                        val titleId: Int? = currentRoute.getRouteTitleId()
                        val iconId: Int? = currentRoute.getRouteTrailingIconId()
                        CustomTopAppBar(
                            title = titleId?.let {
                                stringResource(titleId)
                            } ?: "",
                            trailingIcon = iconId?.let {
                                ImageVector.vectorResource(iconId)
                            },
                            onTrailingIconButtonClick = {},
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    floatingActionButton = {
                        AnimatedVisibility(isActionButtonVisible) {
                            FloatingActionButton(
                                onClick = { },
                                containerColor = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = null
                                )
                            }
                        }
                    },
                    bottomBar = {
                        AppBottomBar(navController)
                    }
                ) { innerPadding ->
                    AppNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}