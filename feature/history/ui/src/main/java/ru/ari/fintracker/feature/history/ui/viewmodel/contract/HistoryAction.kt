package ru.ari.fintracker.feature.history.ui.viewmodel.contract

import java.time.LocalDate

sealed interface HistoryAction {
    data class UpdateDateStart(val date: LocalDate) : HistoryAction
    data class UpdateDateEnd(val date: LocalDate) : HistoryAction
    data object LoadTransactions : HistoryAction
}
