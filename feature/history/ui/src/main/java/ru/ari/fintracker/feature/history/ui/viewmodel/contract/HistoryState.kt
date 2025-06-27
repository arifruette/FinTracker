package ru.ari.fintracker.feature.history.ui.viewmodel.contract

import ru.ari.fintracker.core.domain.models.Transaction
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
