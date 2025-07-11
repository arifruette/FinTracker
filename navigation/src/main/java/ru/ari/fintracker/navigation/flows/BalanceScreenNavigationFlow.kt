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
import ru.ari.fintracker.feature.balance.ui.presentation.BalanceScreenWrapper
import ru.ari.fintracker.feature.edit_balance.ui.presentation.EditBalanceScreenWrapper
import ru.ari.fintracker.navigation.flows.Balance.balanceScreen
import ru.ari.fintracker.navigation.flows.EditBalance.editBalanceScreen
import ru.ari.navigation.R

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
    navigation<BalanceNavigationFlow>(Balance) {
        balanceScreen(
            onTopBarIconClick = {
                navController.navigate(EditBalance) {
                    launchSingleTop = true
                }
            },
            onFloatingButtonClick = { }
        )
        editBalanceScreen(
            onLeadingIconClick = {
                navController.navigate(Balance) {
                    popUpTo(EditBalance) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            })
    }
}

/**
 * Экран баланса
 */
@Serializable
data object Balance : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.balance_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.balance_label)

    fun NavGraphBuilder.balanceScreen(
        onTopBarIconClick: () -> Unit,
        onFloatingButtonClick: () -> Unit
    ) {
        composable<Balance> {
            BalanceScreenWrapper(
                onTopBarIconClick = onTopBarIconClick,
                onFloatingButtonClick = onFloatingButtonClick
            )
        }
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