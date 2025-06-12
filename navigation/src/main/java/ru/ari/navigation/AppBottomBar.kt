package ru.ari.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun AppBottomBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val tabs = NavigationItem.getNavigationItems()
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        tabs.forEach { destination ->
            val isSelected = currentRoute == destination.route.getRouteName()
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            if (isSelected) destination.selectedIcon else destination.unselectedIcon
                        ),
                        contentDescription = stringResource(destination.label)
                    )
                },
                label = {
                    Text(
                        text = stringResource(destination.label),
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight(if (isSelected) 600 else 500)
                        )
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppBottomBarPreview() {
    AppBottomBar(
        navController = rememberNavController(),
    )
}