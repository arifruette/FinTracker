package ru.ari.fintracker.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface Screen {
    @Composable
    fun TopBarTrailingIcon(onClick: () -> Unit, modifier: Modifier)

    @Composable
    fun TopBarLeadingIcon(onClick: () -> Unit, modifier: Modifier)

    @get:Composable
    val title: String
}
