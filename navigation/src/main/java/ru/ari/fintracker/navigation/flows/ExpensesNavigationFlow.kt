package ru.ari.fintracker.navigation.flows

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.ari.fintracker.core.ui.navigation.MainFlowScreen
import ru.ari.fintracker.core.ui.navigation.Screen
import ru.ari.fintracker.feature.expenses.ui.presentation.ExpensesScreenWrapper
import ru.ari.fintracker.feature.history.ui.presentation.HistoryScreenWrapper
import ru.ari.fintracker.navigation.flows.Expenses.expensesScreen
import ru.ari.fintracker.navigation.flows.ExpensesHistory.expensesHistoryScreen
import ru.ari.navigation.R


/**
 * Объект для навигационного потока истории расходов.
 */
@Serializable
data object ExpensesFlow

/**
 * Навигационный граф для экрана истории расходов
 *
 * @param navController контроллер навигации для управления переходами
 */
fun NavGraphBuilder.expensesNavigationFlow(navController: NavHostController) {
    navigation<ExpensesFlow>(Expenses) {
        expensesScreen(
            onTopBarIconClick = {
                navController.navigate(ExpensesHistory)
            },
            onFloatingButtonClick = {}
        )
        expensesHistoryScreen(
            onLeadingIconClick = {
                navController.navigate(ExpensesFlow) {
                    popUpTo(ExpensesHistory) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            },
            onTrailingIconClick = {})
    }
}

/**
 * Экран расходов
 */
@Serializable
data object Expenses : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.expenses_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.expenses_label)

    fun NavGraphBuilder.expensesScreen(
        onTopBarIconClick: () -> Unit,
        onFloatingButtonClick: () -> Unit
    ) {
        composable<Expenses> {
            ExpensesScreenWrapper(
                onTopBarIconClick = onTopBarIconClick,
                onFloatingButtonClick = onFloatingButtonClick
            )
        }
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
