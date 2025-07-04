package ru.ari.fintracker.feature.categories.ui.viewmodel.contract

import ru.ari.fintracker.core.domain.models.Category

/**
 * Все возможные состояния UI при работе со списком категорий:
 */
data class CategoriesUiState(
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val categories: List<Category> = emptyList(),
    val filteredCategories: List<Category> = emptyList(),
    val error: String? = null
)
