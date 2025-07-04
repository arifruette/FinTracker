package ru.ari.fintracker.navigation.flows

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kotlinx.serialization.Serializable
import ru.ari.fintracker.core.ui.navigation.MainFlowScreen
import ru.ari.fintracker.feature.balance.ui.presentation.BalanceScreenWrapper
import ru.ari.fintracker.feature.categories.ui.presentation.CategoriesScreenWrapper
import ru.ari.fintracker.feature.expenses.ui.presentation.ExpensesScreenWrapper
import ru.ari.fintracker.feature.income.ui.presentation.IncomeScreenWrapper
import ru.ari.fintracker.feature.settings.ui.presentation.SettingsScreenWrapper
import ru.ari.fintracker.navigation.flows.Balance.balanceScreen
import ru.ari.fintracker.navigation.flows.Categories.categoriesScreen
import ru.ari.fintracker.navigation.flows.Expenses.expensesScreen
import ru.ari.fintracker.navigation.flows.Income.incomeScreen
import ru.ari.fintracker.navigation.flows.Settings.settingsScreen
import ru.ari.navigation.R

@Serializable
data object MainFlow {
    val routes = listOf(
        Expenses,
        Income,
        Balance,
        Categories,
        Settings
    )
}

/**
 * Построение навигационного графа для основного потока приложения.
 *
 * @param navController контроллер навигации для управления переходами
 */
fun NavGraphBuilder.mainNavigationFlow(navController: NavHostController) {
    navigation<MainFlow>(Expenses) {
        expensesScreen(
            onTopBarIconClick = {
                navController.navigate(ExpensesHistoryFLow)
            },
            onFloatingButtonClick = {}
        )
        incomeScreen(
            onTopBarIconClick = {
                navController.navigate(IncomeHistoryFLow)
            },
            onFloatingButtonClick = {}
        )
        balanceScreen(
            onTopBarIconClick = {
                navController.navigate(BalanceNavigationFlow) {
                    launchSingleTop = true
                }
            },
            onFloatingButtonClick =
                {

                }
        )
        categoriesScreen()
        settingsScreen()
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
 * Экран категорий
 */
@Serializable
data object Categories : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.categories_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.categories_label)

    fun NavGraphBuilder.categoriesScreen() {
        composable<Categories> {
            CategoriesScreenWrapper()
        }
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

/**
 * Экран настроек
 */
@Serializable
data object Settings : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.settings_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.settings_label)

    fun NavGraphBuilder.settingsScreen() {
        composable<Settings> {
            SettingsScreenWrapper()
        }
    }
}
