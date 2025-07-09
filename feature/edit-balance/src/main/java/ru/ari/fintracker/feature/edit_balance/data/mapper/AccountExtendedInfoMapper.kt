package ru.ari.fintracker.feature.edit_balance.data.mapper

import ru.ari.fintracker.core.domain.models.AccountBrief
import ru.ari.fintracker.feature.edit_balance.data.models.AccountExtendedInfoResponse

fun AccountExtendedInfoResponse.toDomain() = AccountBrief(
    id = this.id,
    name = this.name,
    currency = this.currency.toDomainCurrency(),
    balance = this.balance
)