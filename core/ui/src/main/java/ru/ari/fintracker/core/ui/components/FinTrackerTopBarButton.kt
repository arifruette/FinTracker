package ru.ari.fintracker.core.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

/**
 * Стандартная кнопка для верхнего бара приложения
 *
 * @param onClick Обработчик клика по кнопке
 * @param iconId Идентификатор векторного ресурса для иконки
 * @param modifier Модификатор для кастомизации
 */
@Composable
fun FinTrackerTopBarButton(
    onClick: () -> Unit,
    @DrawableRes iconId: Int,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors()
            .copy(contentColor = MaterialTheme.colorScheme.onSurfaceVariant),
        modifier = modifier
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconId),
            contentDescription = null
        )
    }
}
