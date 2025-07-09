package ru.ari.fintracker.feature.categories.data.mapper

import ru.ari.fintracker.core.domain.models.transaction.Category
import ru.ari.fintracker.feature.categories.data.models.CategoryResponse

fun CategoryResponse.toDomain() = Category(
    id = this.id,
    name = this.name,
    emoji = this.emoji,
    isIncome = this.isIncome
)