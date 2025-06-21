package com.example.feature.history.ui

import ru.ari.core.domain.model.Transaction
import java.time.LocalDate

data class HistoryState(
    val dateStart: LocalDate = LocalDate.now().withDayOfMonth(1),
    val dateEnd: LocalDate =  LocalDate.now(),
    val transactions: List<Transaction> = emptyList(),
    val amount: Double = 0.0,
    val currency: String = "₽",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)