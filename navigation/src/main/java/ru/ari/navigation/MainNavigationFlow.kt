package ru.ari.navigation

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kotlinx.serialization.Serializable
import ru.ari.feature.settings.ui.SettingsScreenWrapper
import ru.ari.navigation.Balance.balanceScreen
import ru.ari.navigation.Categories.categoriesScreen
import ru.ari.navigation.Expenses.expensesScreen
import ru.ari.navigation.Income.incomeScreen
import ru.ari.navigation.Settings.settingsScreen
import ru.ari.ui.BalanceScreenWrapper
import ru.ari.ui.CategoriesScreenWrapper
import ru.ari.ui.ExpensesScreenWrapper
import ru.ari.ui.IncomeScreenWrapper
import ru.ari.ui.components.FinTrackerFloatingButton
import ru.ari.ui.components.FinTrackerTopBarButton
import ru.ari.ui.navigation.MainFlowScreen

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

fun NavGraphBuilder.mainNavigationFlow(navController: NavHostController) {
    navigation<MainFlow>(Expenses) {
        expensesScreen(
            onTopBarIconClick = {
                navController.navigate(ExpensesHistoryFLow)
            },
            onFloatingButtonClick = {}
        )
        incomeScreen({}, {})
        balanceScreen({}, {})
        categoriesScreen()
        settingsScreen()
    }
}

@Serializable
data object Expenses : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.expenses_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.expenses_label)

    @Composable
    override fun FloatingButton(onClick: () -> Unit) {
        FinTrackerFloatingButton(onClick)
    }

    @Composable
    override fun TopBarTrailingIcon(onClick: () -> Unit, modifier: Modifier) {
        FinTrackerTopBarButton(
            onClick = onClick,
            iconId = R.drawable.history_icon,
            modifier = modifier
        )
    }

    @Composable
    override fun TopBarLeadingIcon(onClick: () -> Unit, modifier: Modifier) = Unit

    override val title: String
        @Composable
        get() = stringResource(R.string.expenses_title)

    fun NavGraphBuilder.expensesScreen(
        onTopBarIconClick: () -> Unit,
        onFloatingButtonClick: () -> Unit
    ) {
        composable<Expenses> {
            ExpensesScreenWrapper(
                route = Expenses,
                onTopBarIconClick = onTopBarIconClick,
                onFloatingButtonClick = onFloatingButtonClick
            )
        }
    }
}

@Serializable
data object Income : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.income_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.income_label)

    @Composable
    override fun FloatingButton(onClick: () -> Unit) {
        FinTrackerFloatingButton(onClick)
    }

    @Composable
    override fun TopBarTrailingIcon(onClick: () -> Unit, modifier: Modifier) {
        FinTrackerTopBarButton(
            onClick = onClick,
            iconId = R.drawable.history_icon,
            modifier = modifier
        )
    }

    @Composable
    override fun TopBarLeadingIcon(onClick: () -> Unit, modifier: Modifier) = Unit

    override val title: String
        @Composable
        get() = stringResource(R.string.income_title)

    fun NavGraphBuilder.incomeScreen(
        onTopBarIconClick: () -> Unit,
        onFloatingButtonClick: () -> Unit
    ) {
        composable<Income> {
            IncomeScreenWrapper(
                route = Income,
                onTopBarIconClick = onTopBarIconClick,
                onFloatingButtonClick = onFloatingButtonClick
            )
        }
    }
}

@Serializable
data object Categories : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.categories_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.categories_label)

    @Composable
    override fun FloatingButton(onClick: () -> Unit) = Unit

    @Composable
    override fun TopBarTrailingIcon(onClick: () -> Unit, modifier: Modifier) {
        IconButton(onClick = {}) {}
    }

    @Composable
    override fun TopBarLeadingIcon(onClick: () -> Unit, modifier: Modifier) = Unit
    override val title: String
        @Composable
        get() = stringResource(R.string.categories_title)

    fun NavGraphBuilder.categoriesScreen() {
        composable<Categories> {
            CategoriesScreenWrapper(route = Categories)
        }
    }
}


@Serializable
data object Balance : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.balance_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.balance_label)

    @Composable
    override fun FloatingButton(onClick: () -> Unit) {
        FinTrackerFloatingButton(onClick)
    }

    @Composable
    override fun TopBarTrailingIcon(onClick: () -> Unit, modifier: Modifier) {
        FinTrackerTopBarButton(
            onClick = onClick,
            iconId = R.drawable.edit_icon,
            modifier = modifier
        )
    }

    @Composable
    override fun TopBarLeadingIcon(onClick: () -> Unit, modifier: Modifier) = Unit

    override val title: String
        @Composable
        get() = stringResource(R.string.balance_title)

    fun NavGraphBuilder.balanceScreen(
        onTopBarIconClick: () -> Unit,
        onFloatingButtonClick: () -> Unit
    ) {
        composable<Balance> {
            BalanceScreenWrapper(
                route = Balance,
                onTopBarIconClick = onTopBarIconClick,
                onFloatingButtonClick = onFloatingButtonClick
            )
        }
    }
}

@Serializable
data object Settings : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.settings_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.settings_label)

    @Composable
    override fun FloatingButton(onClick: () -> Unit) = Unit

    @Composable
    override fun TopBarTrailingIcon(onClick: () -> Unit, modifier: Modifier) {
        IconButton({}) { }
    }

    @Composable
    override fun TopBarLeadingIcon(onClick: () -> Unit, modifier: Modifier) = Unit

    override val title: String
        @Composable
        get() = stringResource(R.string.settings_title)

    fun NavGraphBuilder.settingsScreen() {
        composable<Settings> {
            SettingsScreenWrapper(route = Settings)
        }
    }
}
