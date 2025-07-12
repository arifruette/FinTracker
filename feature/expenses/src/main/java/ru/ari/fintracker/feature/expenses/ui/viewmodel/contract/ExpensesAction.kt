package ru.ari.fintracker.feature.expenses.ui.viewmodel.contract

sealed interface ExpensesAction {
    data object Refresh: ExpensesAction
}