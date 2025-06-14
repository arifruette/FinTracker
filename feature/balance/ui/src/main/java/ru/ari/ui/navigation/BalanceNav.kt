package ru.ari.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import ru.ari.ui.BalanceScreen
import ru.ari.ui.BalanceViewModel

@Serializable
data object Balance: Screen

fun NavGraphBuilder.balanceScreen() {
    composable<Balance> {
        val viewModel = BalanceViewModel()
        BalanceScreen(viewModel)
    }
}