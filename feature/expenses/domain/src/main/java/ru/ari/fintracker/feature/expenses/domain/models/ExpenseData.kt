package ru.ari.fintracker.feature.expenses.domain.models

import ru.ari.fintracker.core.domain.models.Transaction

data class ExpenseData(
    val expenses: List<Transaction>,
    val amount: Double,
    val currency: String
)
