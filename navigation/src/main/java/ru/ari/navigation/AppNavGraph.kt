package ru.ari.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.ari.ui.navigation.Expenses
import ru.ari.ui.navigation.balanceScreen
import ru.ari.ui.navigation.categoriesScreen
import ru.ari.ui.navigation.expensesScreen
import ru.ari.ui.navigation.incomeScreen
import ru.ari.ui.navigation.settingsScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Expenses,
        modifier = modifier
    ) {
        expensesScreen()
        incomeScreen()
        balanceScreen()
        categoriesScreen()
        settingsScreen()
    }
}