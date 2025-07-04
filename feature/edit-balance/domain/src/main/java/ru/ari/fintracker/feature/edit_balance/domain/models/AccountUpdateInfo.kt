package ru.ari.fintracker.feature.edit_balance.domain.models

data class AccountUpdateInfo(
    val name: String,
    val balance: String,
    val currency: String
)
