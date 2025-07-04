package ru.ari.fintracker.navigation.flows

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.ari.fintracker.core.ui.navigation.Screen
import ru.ari.fintracker.feature.edit_balance.ui.presentation.EditBalanceScreenWrapper
import ru.ari.fintracker.navigation.flows.EditBalance.editBalanceScreen

/**
 * Объект для навигационного потока истории расходов.
 */
@Serializable
data object BalanceNavigationFlow

/**
 * Навигационный граф для экрана истории расходов
 *
 * @param navController контроллер навигации для управления переходами
 */
fun NavGraphBuilder.balanceNavigationFlow(navController: NavHostController) {
    navigation<BalanceNavigationFlow>(EditBalance) {
        editBalanceScreen(
            onLeadingIconClick = {
                navController.navigate(Balance) {
                    popUpTo(EditBalance) {
                        inclusive = true
                    }
                }
            })
    }
}

@Serializable
data object EditBalance : Screen {
    /**
     * Регистрация composable экрана изменения счета в графе навигации
     *
     * @param onLeadingIconClick обработчик клика по иконке "назад"
     */
    fun NavGraphBuilder.editBalanceScreen(
        onLeadingIconClick: () -> Unit
    ) {
        composable<EditBalance> {
            EditBalanceScreenWrapper(
                onCancelButtonClick = onLeadingIconClick
            )
        }
    }
}