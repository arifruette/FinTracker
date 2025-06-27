package ru.ari.fintracker.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Базовый интерфейс для всех экранов приложения.
 *
 * Определяет обязательные элементы UI для верхнего бара:
 * 1. Заголовок экрана
 * 2. Ведущая иконка
 * 3. Трейлинг иконка
 */
interface Screen {

    /**
     * Компонент отрисовки трейлинг иконки
     *
     * @param onClick Обработчик клика по иконке
     * @param modifier Модификатор для кастомизации
     */
    @Composable
    fun TopBarTrailingIcon(onClick: () -> Unit, modifier: Modifier)

    /**
     * Компонент отрисовки ведущей иконки
     *
     * @param onClick Обработчик клика по иконке
     * @param modifier Модификатор для кастомизации
     */
    @Composable
    fun TopBarLeadingIcon(onClick: () -> Unit, modifier: Modifier)

    /**
     * Заголовок экрана, отображаемый в центре верхней панели.
     */
    @get:Composable
    val title: String
}
