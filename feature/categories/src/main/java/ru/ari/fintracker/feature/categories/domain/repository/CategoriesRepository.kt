package ru.ari.fintracker.feature.categories.domain.repository

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.transaction.Category

/**
 * Интерфейс, описывающий бизнес-правила получения категорий
 */
interface CategoriesRepository {
    suspend fun getCategories(): Result<List<Category>>
    suspend fun getCategoriesByType(isIncome: Boolean): Result<List<Category>>
}
