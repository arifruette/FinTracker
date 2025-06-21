package ru.ari.feature.income.domain.model

import ru.ari.core.domain.model.Transaction

data class IncomeData(
    val income: List<Transaction>,
    val amount: Double,
    val currency: String
)
