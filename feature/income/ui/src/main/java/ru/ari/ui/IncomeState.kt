package ru.ari.ui

import ru.ari.feature.income.domain.model.Income

sealed interface IncomeState {
    data object Loading : IncomeState
    data class Success(val totalAmount: String, val incomes: List<Income>) : IncomeState
    data class Error(val message: String): IncomeState
}