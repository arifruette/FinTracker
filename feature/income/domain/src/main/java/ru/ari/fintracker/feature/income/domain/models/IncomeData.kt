package ru.ari.fintracker.feature.income.domain.models

import ru.ari.fintracker.core.domain.models.Transaction

data class IncomeData(
    val income: List<Transaction>,
    val amount: Double,
    val currency: String
)
