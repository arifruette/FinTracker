package ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.contract

import java.time.LocalDate
import java.time.LocalTime


sealed interface ManageTransactionAction {
    data object ChangeDatePickerVisibility: ManageTransactionAction
    data object ChangeTimePickerVisibility: ManageTransactionAction
    data class UpdateDate(val newDate: LocalDate): ManageTransactionAction
    data class UpdateTotalAmount(val newAmount: String): ManageTransactionAction
    data class UpdateTime(val newTime: LocalTime): ManageTransactionAction
    data class UpdateDescription(val newDescription: String): ManageTransactionAction
}