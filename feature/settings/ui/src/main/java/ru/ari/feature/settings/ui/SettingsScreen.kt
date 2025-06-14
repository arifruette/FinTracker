package ru.ari.feature.settings.ui

import ListItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
    ) {
        ListItem(
            content = "Тёмная тема",
            trailingContent = {
                Switch(
                    checked = uiState.value.isDarkTheme,
                    onCheckedChange = { viewModel.toggleDarkTheme() }
                )
            },
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Основной цвет",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Звуки",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Хаптики",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Код пароль",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Синхронизация",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Язык",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "О программе",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
    }
}