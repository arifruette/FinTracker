package ru.ari.ui

import ru.ari.core.domain.model.Transaction


data class IncomeState(
    val incomes: List<Transaction> = emptyList(),
    val amount: Double = 0.0,
    val currency: String = "₽",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)