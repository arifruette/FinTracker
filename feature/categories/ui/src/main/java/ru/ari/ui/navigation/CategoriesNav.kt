package ru.ari.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import ru.ari.ui.CategoriesScreen

@Serializable
data object Categories : Screen

fun NavGraphBuilder.categoriesScreen() {
    composable<Categories> {
        CategoriesScreen()
    }
}