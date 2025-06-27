package ru.ari.fintracker.feature.categories.domain.repository

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.feature.categories.domain.models.Category

/**
 * Интерфейс, описывающий бизнес-правила получения категорий
 */
interface CategoriesRepository {
    suspend fun getCategories(): Result<List<Category>>
}
