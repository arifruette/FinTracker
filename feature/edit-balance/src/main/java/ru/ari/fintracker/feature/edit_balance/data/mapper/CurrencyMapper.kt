package ru.ari.fintracker.feature.edit_balance.data.mapper

import ru.ari.fintracker.core.domain.models.Currency

fun String?.toDomainCurrency(): Currency =
    Currency.entries.firstOrNull { it.name == this?.uppercase() } ?: Currency.RUB