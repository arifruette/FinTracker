package ru.ari.fintracker.core.data.models

data class TransactionResponse(
    val id: Long,
    val account: AccountBriefResponse,
    val category: CategoryResponse,
    val amount: Double,
    val transactionDate: String,
    val comment: String?,
    val createdAt: String,
    val updatedAt: String
)
