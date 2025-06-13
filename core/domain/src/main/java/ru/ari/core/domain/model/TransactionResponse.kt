package ru.ari.core.domain.model

import kotlinx.datetime.Instant

data class TransactionResponse(
    val id: Int,
    val account: TransactionResponse,
    val categoryId: String,
    val amount: Double,
    val transactionDate: Instant,
    val comment: String?,
    val createdAt: Instant,
    val updatedAt: Instant
)