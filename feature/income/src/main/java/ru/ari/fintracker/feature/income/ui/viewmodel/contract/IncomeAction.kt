package ru.ari.fintracker.feature.income.ui.viewmodel.contract

sealed interface IncomeAction {
    data object Refresh: IncomeAction
}