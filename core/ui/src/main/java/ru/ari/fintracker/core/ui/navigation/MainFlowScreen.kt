package ru.ari.fintracker.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Интерфейс для экранов основного потока приложения с нижней навигацией
 */
interface MainFlowScreen : Screen {
    /**
     * Иконка для отображения в нижней навигационной панели
     */
    @get:Composable
    val icon: ImageVector

    /**
     * Текстовая метка для нижней навигационной панели
     */
    @get:Composable
    val label: String

    /**
     * Компонент, который создает плавающую кнопку действия для экрана
     * @param onClick Обработчик клика по кнопке
     */
    @Composable
    fun FloatingButton(onClick: () -> Unit)
}
