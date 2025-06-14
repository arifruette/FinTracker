package ru.ari.navigation

import ru.ari.feature.settings.ui.navigation.Settings
import ru.ari.ui.navigation.Balance
import ru.ari.ui.navigation.Categories
import ru.ari.ui.navigation.Expenses
import ru.ari.ui.navigation.Income
import ru.ari.ui.navigation.Screen


sealed class NavigationItem(
    val route: Screen,
    val label: Int,
    val title: Int,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val topBarIcon: Int? = null,
) {
    data object ExpensesScreen : NavigationItem(
        route = Expenses,
        label = R.string.expenses_label,
        title = R.string.expenses_title,
        selectedIcon = R.drawable.expenses_selected_icon,
        unselectedIcon = R.drawable.expenses_unselected_icon,
        topBarIcon = R.drawable.history_icon
    )

    data object IncomeScreen : NavigationItem(
        route = Income,
        label = R.string.income_label,
        title = R.string.income_title,
        selectedIcon = R.drawable.income_selected_icon,
        unselectedIcon = R.drawable.income_unselected_icon,
        topBarIcon = R.drawable.history_icon
    )

    data object BalanceScreen : NavigationItem(
        route = Balance,
        label = R.string.balance_label,
        title = R.string.balance_title,
        selectedIcon = R.drawable.balance_selected_icon,
        unselectedIcon = R.drawable.balance_unselected_icon,
        topBarIcon = R.drawable.edit_icon
    )

    data object CategoriesScreen : NavigationItem(
        route = Categories,
        label = R.string.categories_label,
        title = R.string.categories_title,
        selectedIcon = R.drawable.categories_selected_icon,
        unselectedIcon = R.drawable.categories_unselected_icon
    )

    data object SettingsScreen : NavigationItem(
        route = Settings,
        label = R.string.settings_label,
        title = R.string.settings_title,
        selectedIcon = R.drawable.settings_selected_icon,
        unselectedIcon = R.drawable.settings_unselected_icon
    )

    companion object {
        fun getNavigationItems() = listOf(
            ExpensesScreen, IncomeScreen, BalanceScreen,
            CategoriesScreen, SettingsScreen
        )

        fun getRoutesWithFloatingButton() = listOf(
            ExpensesScreen.route.getRouteName(),
            IncomeScreen.route.getRouteName(),
            BalanceScreen.route.getRouteName()
        )
    }
}