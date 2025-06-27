package ru.ari.fintracker.feature.categories.domain.models

/**
 * Модель данных, представляющая категорию транзакции
 *
 * @property id Уникальный идентификатор категории
 * @property name Название категории для отображения в UI
 * @property icon Визуальный идентификатор (emoji)
 */
data class Category(
    val id: Int,
    val name: String,
    val icon: String
)
