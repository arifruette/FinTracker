package ru.ari.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import ru.ari.ui.IncomeScreen
import ru.ari.ui.IncomesViewModel

@Serializable
data object Income : Screen

fun NavGraphBuilder.incomeScreen() {
    composable<Income> {
        val viewModel = IncomesViewModel()
        IncomeScreen(
            viewModel
        )
    }
}