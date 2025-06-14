package ru.ari.ui

import ru.ari.domain.model.Category

sealed interface CategoriesState{
    data object Loading : CategoriesState
    data class Success(val searchTextState: String, val categories: List<Category>) : CategoriesState
    data class Error(val message: String) : CategoriesState
}
