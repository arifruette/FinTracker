package ru.ari.fintracker.feature.edit_balance.ui.viewmodel.contract

import ru.ari.fintracker.core.domain.models.Currency

sealed interface EditScreenAction{
    data class UpdateAccountInfo(val onSuccess: () -> Unit): EditScreenAction
    data class ChangeAccountAmount(val newAmount: String): EditScreenAction
    data class ChangeAccountName(val newName: String): EditScreenAction
    data class ChangeAccountCurrency(val newCurrency: Currency): EditScreenAction
    data object ChangeBottomSheetVisibility: EditScreenAction
}