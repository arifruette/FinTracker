package ru.ari.fintracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.ari.fintracker.navigation.flows.MainFlow
import ru.ari.fintracker.navigation.flows.expensesHistoryNavigationFlow
import ru.ari.fintracker.navigation.flows.incomeHistoryNavigationFlow
import ru.ari.fintracker.navigation.flows.mainNavigationFlow

/**
 * Главный навигационный граф приложения
 *
 * @param modifier модификатор для настройки внешнего вида
 * @param navController контроллер навигации для управления переходами
 */
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
