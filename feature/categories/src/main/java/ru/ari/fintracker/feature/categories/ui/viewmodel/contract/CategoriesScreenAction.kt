package ru.ari.fintracker.feature.categories.ui.viewmodel.contract

sealed interface CategoriesScreenAction {
    data class ChangeSearchQueryState(val newSearchQuery: String): CategoriesScreenAction
}