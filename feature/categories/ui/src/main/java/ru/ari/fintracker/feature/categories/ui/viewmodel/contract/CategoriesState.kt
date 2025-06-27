package ru.ari.fintracker.feature.categories.ui.viewmodel.contract

import ru.ari.fintracker.feature.categories.domain.models.Category

sealed interface CategoriesState{
    data object Loading : CategoriesState
    data class Success(val searchTextState: String, val categories: List<Category>) : CategoriesState
    data class Error(val message: String) : CategoriesState
}
