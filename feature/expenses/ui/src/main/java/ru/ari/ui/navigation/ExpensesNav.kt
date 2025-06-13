package ru.ari.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import ru.ari.ui.ExpensesScreen
import ru.ari.ui.ExpensesViewModel

@Serializable
data object Expenses : Screen

fun NavGraphBuilder.expensesScreen() {
    composable<Expenses> {
        val viewModel = ExpensesViewModel()
        ExpensesScreen(viewModel)
    }
}