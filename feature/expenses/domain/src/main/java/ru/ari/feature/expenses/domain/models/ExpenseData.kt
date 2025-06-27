package ru.ari.feature.expenses.domain.models

import ru.ari.core.domain.models.Transaction

data class ExpenseData(
    val expenses: List<Transaction>,
    val amount: Double,
    val currency: String
)