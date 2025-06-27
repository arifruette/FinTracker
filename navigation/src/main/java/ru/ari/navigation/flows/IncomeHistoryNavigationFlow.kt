package ru.ari.navigation.flows

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.feature.history.ui.HistoryScreenWrapper
import kotlinx.serialization.Serializable
import ru.ari.navigation.R
import ru.ari.navigation.flows.IncomeHistory.incomeHistoryScreen
import ru.ari.ui.components.FinTrackerTopBarButton
import ru.ari.ui.navigation.Screen

@Serializable
data object IncomeHistoryFLow

fun NavGraphBuilder.incomeHistoryNavigationFlow(navController: NavHostController) {
    navigation<IncomeHistoryFLow>(IncomeHistory) {
        incomeHistoryScreen(onLeadingIconClick = {
            navController.navigate(Income) {
                popUpTo(IncomeHistory) {
                    inclusive = true
                }
            }
        }, {})
    }
}

@Serializable
data object IncomeHistory : Screen {
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

    fun NavGraphBuilder.incomeHistoryScreen(
        onLeadingIconClick: () -> Unit,
        onTrailingIconClick: () -> Unit
    ) {
        composable<IncomeHistory> {
            HistoryScreenWrapper(
                route = IncomeHistory,
                isIncomeScreen = true,
                onLeadingIconClick = onLeadingIconClick,
                onTrailingIconClick = onTrailingIconClick
            )
        }
    }
}
