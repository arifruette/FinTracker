package ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract

sealed interface EditScreenUiEffect {
    data class ShowError(val message: String): EditScreenUiEffect
}