package com.example.core.data.mapper

import com.example.core.data.model.AccountBriefResponse
import ru.ari.core.domain.model.AccountBrief


fun AccountBriefResponse.toDomain(): AccountBrief {
    return AccountBrief(
        id = id,
        name = name,
        currency = currency
    )
}
