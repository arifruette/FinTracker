package ru.ari.fintracker.navigation.flows

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.ari.fintracker.core.ui.navigation.Screen
import ru.ari.fintracker.feature.history.ui.presentation.HistoryScreenWrapper
import ru.ari.fintracker.navigation.flows.IncomeHistory.incomeHistoryScreen

/**
 * Объект для навигационного потока истории доходов.
 */
@Serializable
data object IncomeHistoryFLow

/**
 * Навигационный граф для экрана истории доходов.
 *
 * @param navController контроллер навигации для управления переходами
 */
fun NavGraphBuilder.incomeHistoryNavigationFlow(navController: NavHostController) {
    navigation<IncomeHistoryFLow>(IncomeHistory) {
        incomeHistoryScreen(onLeadingIconClick = {
            navController.navigate(Income) {
                popUpTo(IncomeHistory) {
                    inclusive = true
                }
            }
        }, {})
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
