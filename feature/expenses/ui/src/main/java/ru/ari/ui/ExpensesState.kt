package ru.ari.ui

import ru.ari.feature.expenses.domain.Expense

sealed interface ExpensesState {
    data object Loading : ExpensesState
    data class Success(val totalAmount: String, val expenses: List<Expense>) : ExpensesState
    data class Error(val message: String): ExpensesState
}