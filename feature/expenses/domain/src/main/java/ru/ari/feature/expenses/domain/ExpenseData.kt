package ru.ari.feature.expenses.domain

import ru.ari.core.domain.model.Transaction

data class ExpenseData(
    val expenses: List<Transaction>,
    val amount: Double,
    val currency: String
)
