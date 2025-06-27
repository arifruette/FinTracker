package ru.ari.feature.income.domain.models

import ru.ari.core.domain.models.Transaction

data class IncomeData(
    val income: List<Transaction>,
    val amount: Double,
    val currency: String
)
