package ru.ari.fintracker.core.data.mapper.transaction

import ru.ari.fintracker.core.data.models.transaction.CategoryResponse
import ru.ari.fintracker.core.domain.models.transaction.Category

fun CategoryResponse.toDomain(): Category {
    return Category(
        id = id,
        name = name,
        emoji = emoji,
        isIncome = isIncome
    )
}
