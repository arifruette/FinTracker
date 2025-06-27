package ru.ari.feature.settings.ui.presentation.components

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
import ru.ari.feature.settings.ui.R
import ru.ari.feature.settings.ui.viewmodel.contract.SettingsState

@Composable
fun SettingsScreen(
    uiState: SettingsState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        ListItem(
            content = "Тёмная тема",
            trailingContent = {
                Switch(
                    checked = uiState.isDarkTheme,
                    onCheckedChange = { }
                )
            },
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Основной цвет",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            onItemClick = {},
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Звуки",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            onItemClick = {},
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Хаптики",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            onItemClick = {},
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Код пароль",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            onItemClick = {},
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Синхронизация",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            onItemClick = {},
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "Язык",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            onItemClick = {},
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        ListItem(
            content = "О программе",
            trailingIcon = ImageVector.vectorResource(R.drawable.arrow_right),
            onItemClick = {},
            modifier = Modifier.height(56.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
    }
}
