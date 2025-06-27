package ru.ari.fintracker.core.data.mapper

import ru.ari.fintracker.core.data.models.AccountBriefResponse
import ru.ari.fintracker.core.domain.models.AccountBrief

fun AccountBriefResponse.toDomain(): AccountBrief = AccountBrief(
    id = this.id,
    name = this.name,
    currency = this.currency,
    balance = this.balance
)
