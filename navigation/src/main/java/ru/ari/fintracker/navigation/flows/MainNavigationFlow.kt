package ru.ari.fintracker.navigation.flows

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import ru.ari.fintracker.core.ui.navigation.MainFlowScreen
import ru.ari.fintracker.feature.categories.ui.presentation.CategoriesScreenWrapper
import ru.ari.fintracker.feature.settings.ui.presentation.SettingsScreenWrapper
import ru.ari.fintracker.navigation.flows.Categories.categoriesScreen
import ru.ari.fintracker.navigation.flows.Settings.settingsScreen
import ru.ari.navigation.R

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

/**
 * Построение навигационного графа для основного потока приложения.
 *
 * @param navController контроллер навигации для управления переходами
 */
fun NavGraphBuilder.mainNavigationFlow(navController: NavHostController) {
    navigation<MainFlow>(ExpensesFlow) {
        expensesNavigationFlow(navController)
        incomeNavigationFlow(navController)
        balanceNavigationFlow(navController)
        categoriesScreen()
        settingsScreen()
    }
}

/**
 * Экран категорий
 */
@Serializable
data object Categories : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.categories_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.categories_label)

    fun NavGraphBuilder.categoriesScreen() {
        composable<Categories> {
            CategoriesScreenWrapper()
        }
    }
}

/**
 * Экран настроек
 */
@Serializable
data object Settings : MainFlowScreen {
    override val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.settings_icon)
    override val label: String
        @Composable
        get() = stringResource(R.string.settings_label)

    fun NavGraphBuilder.settingsScreen() {
        composable<Settings> {
            SettingsScreenWrapper()
        }
    }
}
