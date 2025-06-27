package ru.ari.fintracker.core.domain.models

import java.time.LocalDateTime

data class Transaction(
    val id: Long,
    val account: AccountBrief,
    val category: Category,
    val amount: Double,
    val date: LocalDateTime,
    val comment: String?
)
