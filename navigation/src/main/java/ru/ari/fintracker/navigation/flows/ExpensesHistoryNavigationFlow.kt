package ru.ari.fintracker.navigation.flows

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.ari.fintracker.core.ui.components.FinTrackerTopBarButton
import ru.ari.fintracker.core.ui.navigation.Screen
import ru.ari.fintracker.feature.history.ui.presentation.HistoryScreenWrapper
import ru.ari.fintracker.navigation.flows.ExpensesHistory.expensesHistoryScreen
import ru.ari.navigation.R

@Serializable
data object ExpensesHistoryFLow

fun NavGraphBuilder.expensesHistoryNavigationFlow(navController: NavHostController) {
    navigation<ExpensesHistoryFLow>(ExpensesHistory) {
        expensesHistoryScreen({
            navController.navigate(MainFlow) {
                popUpTo(ExpensesHistory) {
                    inclusive = true
                }
            }
        }, {})
    }
}

@Serializable
data object ExpensesHistory : Screen {
    @Composable
    override fun TopBarTrailingIcon(onClick: () -> Unit, modifier: Modifier) {
        FinTrackerTopBarButton(
            onClick = onClick,
            iconId = R.drawable.analysis_icon,
            modifier = modifier
        )
    }

    @Composable
    override fun TopBarLeadingIcon(onClick: () -> Unit, modifier: Modifier) {
        FinTrackerTopBarButton(
            onClick = onClick,
            iconId = R.drawable.back_arrow_icon,
            modifier = modifier
        )
    }

    override val title: String
        @Composable
        get() = stringResource(R.string.history_screen_title)

    fun NavGraphBuilder.expensesHistoryScreen(
        onLeadingIconClick: () -> Unit,
        onTrailingIconClick: () -> Unit
    ) {
        composable<ExpensesHistory> {
            HistoryScreenWrapper(
                route = ExpensesHistory,
                onLeadingIconClick = onLeadingIconClick,
                onTrailingIconClick = onTrailingIconClick
            )
        }
    }
}
