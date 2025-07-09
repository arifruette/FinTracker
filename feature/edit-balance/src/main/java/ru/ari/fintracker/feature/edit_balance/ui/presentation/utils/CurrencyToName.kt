package ru.ari.fintracker.feature.edit_balance.ui.presentation.utils

import ru.ari.fintracker.core.domain.models.account.Currency

fun Currency.toLongName() = when (this) {
    Currency.RUB -> "Российский рубль"
    Currency.USD -> "Американский доллар"
    Currency.EUR -> "Евро"
}