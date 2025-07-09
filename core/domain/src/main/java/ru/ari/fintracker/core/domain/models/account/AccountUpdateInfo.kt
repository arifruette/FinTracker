package ru.ari.fintracker.core.domain.models.account

data class AccountUpdateInfo(
    val name: String,
    val balance: String,
    val currency: String
)
