package ru.ari.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MainFlow,
        modifier = modifier
    ) {
        mainNavigationFlow(navController)
        expensesHistoryNavigationFlow(navController)
        incomeHistoryNavigationFlow(navController)
    }
}