package com.example.feature.history.domain.model

import ru.ari.core.domain.model.Transaction

data class HistoryData(
    val transactions: List<Transaction>,
    val amount: Double,
    val currency: String
)