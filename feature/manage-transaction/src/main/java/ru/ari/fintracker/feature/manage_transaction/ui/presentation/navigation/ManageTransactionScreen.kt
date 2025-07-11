package ru.ari.fintracker.feature.manage_transaction.ui.presentation.navigation

import kotlinx.serialization.Serializable
import ru.ari.fintracker.core.ui.navigation.Screen

sealed interface ManageTransactionScreen: Screen

@Serializable
data class ManageIncomeScreen(val transactionId: Long? = null): ManageTransactionScreen

@Serializable
data class ManageExpenseScreen(val transactionId: Long? = null): ManageTransactionScreen