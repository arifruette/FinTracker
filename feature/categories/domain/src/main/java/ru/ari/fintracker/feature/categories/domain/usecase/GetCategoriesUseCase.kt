package ru.ari.fintracker.feature.categories.domain.usecase

import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.Category
import ru.ari.fintracker.feature.categories.domain.repository.CategoriesRepository
import javax.inject.Inject

/**
 * UseCase получения списка категорий
 */
class GetCategoriesUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) {
    suspend operator fun invoke(): Result<List<Category>> {
        return categoriesRepository.getCategories()
    }
}
