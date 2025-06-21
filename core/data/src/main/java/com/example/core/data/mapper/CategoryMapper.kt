package com.example.core.data.mapper

import com.example.core.data.model.CategoryResponse
import ru.ari.core.domain.model.Category

fun CategoryResponse.toDomain(): Category {
    return Category(
        id = id,
        name = name,
        emoji = emoji,
        isIncome = isIncome
    )
}