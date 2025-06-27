package ru.ari.fintracker.core.data.models

/**
 * Категория для классификации транзакций
 *
 * @property id Уникальный идентификатор категории
 * @property name Название категории
 * @property emoji Иконка-эмодзи (юникод символ)
 * @property isIncome Признак категории доходов
 */
data class CategoryResponse(
    val id: Long,
    val name: String,
    val emoji: String,
    val isIncome: Boolean
)
