package ru.ari.fintracker.core.data.mapper.transaction

import ru.ari.fintracker.core.data.mapper.toDomainCurrency
import ru.ari.fintracker.core.data.models.account.AccountBriefResponse
import ru.ari.fintracker.core.domain.models.account.AccountBrief

fun AccountBriefResponse.toDomain(): AccountBrief = AccountBrief(
    id = this.id,
    name = this.name,
    currency = this.currency.toDomainCurrency(),
    balance = this.balance
)
