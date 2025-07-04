package ru.ari.fintracker.core.data.mapper.transaction

import ru.ari.fintracker.core.data.mapper.toDomainCurrency
import ru.ari.fintracker.core.data.models.transaction.AccountBriefResponse
import ru.ari.fintracker.core.domain.models.AccountBrief

fun AccountBriefResponse.toDomain(): AccountBrief = AccountBrief(
    id = this.id,
    name = this.name,
    currency = this.currency.toDomainCurrency(),
    balance = this.balance
)
