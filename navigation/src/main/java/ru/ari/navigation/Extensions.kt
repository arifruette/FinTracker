package ru.ari.navigation

import ru.ari.ui.navigation.Screen

fun Screen.getRouteName(): String {
    return this::class.java.canonicalName.orEmpty()
}

fun String?.getRouteTitleId(): Int? {
    return when (this) {
        NavigationItem.ExpensesScreen.route.getRouteName() -> {
            NavigationItem.ExpensesScreen.title
        }
        NavigationItem.IncomeScreen.route.getRouteName() -> {
            NavigationItem.IncomeScreen.title
        }
        NavigationItem.BalanceScreen.route.getRouteName() -> {
            NavigationItem.BalanceScreen.title
        }
        NavigationItem.CategoriesScreen.route.getRouteName() -> {
            NavigationItem.CategoriesScreen.title
        }
        NavigationItem.SettingsScreen.route.getRouteName() -> {
            NavigationItem.SettingsScreen.title
        }
        else -> null
    }
}

fun String?.getRouteTrailingIconId(): Int? {
    return when (this) {
        NavigationItem.ExpensesScreen.route.getRouteName() -> {
            NavigationItem.ExpensesScreen.topBarIcon
        }
        NavigationItem.IncomeScreen.route.getRouteName() -> {
            NavigationItem.IncomeScreen.topBarIcon
        }
        NavigationItem.BalanceScreen.route.getRouteName() -> {
            NavigationItem.BalanceScreen.topBarIcon
        }
        NavigationItem.CategoriesScreen.route.getRouteName() -> {
            NavigationItem.CategoriesScreen.topBarIcon
        }
        NavigationItem.SettingsScreen.route.getRouteName() -> {
            NavigationItem.SettingsScreen.topBarIcon
        }
        else -> null
    }
}