package com.example.feature.history.domain.models

import ru.ari.core.domain.models.Transaction

data class HistoryData(
    val transactions: List<Transaction>,
    val amount: Double,
    val currency: String
)
