package ru.ari.fintracker.core.data.mapper

import ru.ari.fintracker.core.domain.models.account.Currency

fun String?.toDomainCurrency(): Currency =
    Currency.entries.firstOrNull { it.name == this?.uppercase() } ?: Currency.RUB