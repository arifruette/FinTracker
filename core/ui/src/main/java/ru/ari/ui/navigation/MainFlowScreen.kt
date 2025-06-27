package ru.ari.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

interface MainFlowScreen : Screen {
    @get:Composable
    val icon: ImageVector

    @get:Composable
    val label: String

    @Composable
    fun FloatingButton(onClick: () -> Unit)
}