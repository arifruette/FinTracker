package ru.ari.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

interface Screen {
    @Composable
    fun TopBarIcon(onClick: () -> Unit, modifier: Modifier)

    @get:Composable
    val title: String
}

interface MainFlowScreen : Screen {
    @get:Composable
    val icon: ImageVector

    @get:Composable
    val label: String

    @Composable
    fun FloatingButton(onClick: () -> Unit)
}