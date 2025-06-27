package com.example.core.data.mapper

import com.example.core.data.models.CategoryResponse
import ru.ari.core.domain.models.Category

fun CategoryResponse.toDomain(): Category {
    return Category(
        id = id,
        name = name,
        emoji = emoji,
        isIncome = isIncome
    )
}
