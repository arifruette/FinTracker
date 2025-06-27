package ru.ari.fintracker.feature.categories.ui.viewmodel.contract

import ru.ari.fintracker.feature.categories.domain.models.Category

/**
 * Все возможные состояния UI при работе со списком категорий:
 */
data class CategoriesState(
    val isLoading: Boolean = false,
    val searchTextState: String = "",
    val categories: List<Category> = emptyList(),
    val error: String? = null
)
