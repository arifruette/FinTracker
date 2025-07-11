package ru.ari.fintracker.navigation.flows

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import ru.ari.fintracker.core.ui.navigation.MainFlowScreen
import ru.ari.fintracker.core.ui.navigation.Screen
import ru.ari.fintracker.feature.history.ui.presentation.HistoryScreenWrapper
import ru.ari.fintracker.feature.income.ui.presentation.IncomeScreenWrapper
import ru.ari.fintracker.feature.manage_transaction.ui.presentation.ManageTransactionScreenWrapper
import ru.ari.fintracker.feature.manage_transaction.ui.presentation.navigation.ManageIncomeData
import ru.ari.fintracker.navigation.flows.Income.incomeScreen
import ru.ari.fintracker.navigation.flows.IncomeHistory.incomeHistoryScreen
import ru.ari.fintracker.navigation.flows.ManageIncome.incomeManageScreen
import ru.ari.navigation.R

/**
 * Объект для навигационного потока истории доходов.
 */
@Serializable
data object IncomeFLow

/**
 * Навигационный граф для экрана истории доходов.
 *
 * @param navController контроллер навигации для управления переходами
 */
fun NavGraphBuilder.incomeNavigationFlow(navController: NavHostController) {
    navigation<IncomeFLow>(Income) {
        incomeScreen(
            onTopBarIconClick = {
                navController.navigate(IncomeHistory)
            },
            onFloatingButtonClick = {
                navController.navigate(ManageIncome)
            }
        )
        incomeHistoryScreen(
            onLeadingIconClick = {
                navController.navigate(Income) {
                    popUpTo(IncomeHistory) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            },
            onTrailingIconClick = {}
        )
        incomeManageScreen(
            onCancelButtonClick = {
                navController.navigate(Income) {
                    popUpTo(ManageIncome) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        )
    }
}

/**
 * Экран доходов
 */
@Serializable
data object Income : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.income_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.income_label)

    fun NavGraphBuilder.incomeScreen(
        onTopBarIconClick: () -> Unit,
        onFloatingButtonClick: () -> Unit
    ) {
        composable<Income> {
            IncomeScreenWrapper(
                onTopBarIconClick = onTopBarIconClick,
                onFloatingButtonClick = onFloatingButtonClick
            )
        }
    }
}

/**
 * Объект экрана истории доходов, реализующий интерфейс Screen.
 */
@Serializable
data object IncomeHistory : Screen {
    /**
     * Регистрация composable экрана истории доходов в графе навигации
     *
     * @param onLeadingIconClick обработчик клика по иконке "назад"
     * @param onTrailingIconClick обработчик клика по дополнительной иконке
     */
    fun NavGraphBuilder.incomeHistoryScreen(
        onLeadingIconClick: () -> Unit,
        onTrailingIconClick: () -> Unit
    ) {
        composable<IncomeHistory> {
            HistoryScreenWrapper(
                isIncomeScreen = true,
                onLeadingIconClick = onLeadingIconClick,
                onTrailingIconClick = onTrailingIconClick
            )
        }
    }
}


@Serializable
data object ManageIncome : Screen {
    fun NavGraphBuilder.incomeManageScreen(
        onCancelButtonClick: () -> Unit
    ) {
        composable<ManageIncome> { backStackEntry ->
            val transactionId = backStackEntry.toRoute<ManageIncomeData>()
            ManageTransactionScreenWrapper(
                transactionId = transactionId.incomeId,
                isIncome = true,
                onCancelButtonClick = onCancelButtonClick
            )
        }
    }
}