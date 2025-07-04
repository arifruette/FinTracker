package ru.ari.fintracker.navigation.flows

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.ari.fintracker.core.ui.navigation.Screen
import ru.ari.fintracker.feature.history.ui.presentation.HistoryScreenWrapper
import ru.ari.fintracker.navigation.flows.ExpensesHistory.expensesHistoryScreen


/**
 * Объект для навигационного потока истории расходов.
 */
@Serializable
data object ExpensesHistoryFLow

/**
 * Навигационный граф для экрана истории расходов
 *
 * @param navController контроллер навигации для управления переходами
 */
fun NavGraphBuilder.expensesHistoryNavigationFlow(navController: NavHostController) {
    navigation<ExpensesHistoryFLow>(ExpensesHistory) {
        expensesHistoryScreen({
            navController.navigate(MainFlow) {
                popUpTo(ExpensesHistory) {
                    inclusive = true
                }
            }
        }, {})
    }
}

/**
 * Объект экрана истории расходов, реализующий интерфейс Screen.
 */
@Serializable
data object ExpensesHistory : Screen {
    /**
     * Регистрация composable экрана истории расходов в графе навигации
     *
     * @param onLeadingIconClick обработчик клика по иконке "назад"
     * @param onTrailingIconClick обработчик клика по дополнительной иконке
     */
    fun NavGraphBuilder.expensesHistoryScreen(
        onLeadingIconClick: () -> Unit,
        onTrailingIconClick: () -> Unit
    ) {
        composable<ExpensesHistory> {
            HistoryScreenWrapper(
                onLeadingIconClick = onLeadingIconClick,
                onTrailingIconClick = onTrailingIconClick
            )
        }
    }
}
