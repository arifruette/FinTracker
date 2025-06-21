package ru.ari.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.feature.history.ui.HistoryScreenWrapper
import kotlinx.serialization.Serializable
import ru.ari.navigation.ExpensesHistory.expensesHistoryScreen
import ru.ari.ui.components.FinTrackerTopBarButton
import ru.ari.ui.navigation.Screen

@Serializable
data object ExpensesHistoryFLow

fun NavGraphBuilder.expensesHistoryNavigationFlow(navController: NavHostController) {
    navigation<ExpensesHistoryFLow>(ExpensesHistory) {
        expensesHistoryScreen({}, {})
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