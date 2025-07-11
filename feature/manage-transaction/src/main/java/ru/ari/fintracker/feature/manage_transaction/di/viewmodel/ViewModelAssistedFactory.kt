package ru.ari.fintracker.feature.manage_transaction.di.viewmodel

import dagger.assisted.AssistedFactory
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.ManageTransactionViewModel

@AssistedFactory
interface ViewModelAssistedFactory {
    fun create(isIncomeScreen: Boolean): ManageTransactionViewModel
}