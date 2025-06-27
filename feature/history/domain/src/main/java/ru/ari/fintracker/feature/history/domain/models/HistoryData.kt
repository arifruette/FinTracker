package ru.ari.fintracker.feature.history.domain.models

import ru.ari.fintracker.core.domain.models.Transaction

data class HistoryData(
    val transactions: List<Transaction>,
    val amount: Double,
    val currency: String
)
