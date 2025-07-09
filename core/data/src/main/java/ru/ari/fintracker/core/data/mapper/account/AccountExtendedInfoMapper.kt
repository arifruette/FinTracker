package ru.ari.fintracker.core.data.mapper.account

import ru.ari.fintracker.core.data.mapper.toDomainCurrency
import ru.ari.fintracker.core.data.models.account.AccountExtendedInfoResponse
import ru.ari.fintracker.core.domain.models.account.AccountBrief

fun AccountExtendedInfoResponse.toDomain() = AccountBrief(
    id = this.id,
    name = this.name,
    currency = this.currency.toDomainCurrency(),
    balance = this.balance
)