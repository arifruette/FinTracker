package ru.ari.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import ru.ari.ui.ExpensesScreen

@Serializable
data object Expenses : Screen

fun NavGraphBuilder.expensesScreen() {
    composable<Expenses> {
        ExpensesScreen()
    }
}