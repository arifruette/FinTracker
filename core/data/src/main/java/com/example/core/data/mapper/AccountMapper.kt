package com.example.core.data.mapper

import com.example.core.data.models.AccountBriefResponse
import ru.ari.core.domain.models.AccountBrief


fun AccountBriefResponse.toDomain(): AccountBrief {
    return AccountBrief(
        id = id,
        name = name,
        currency = currency
    )
}
