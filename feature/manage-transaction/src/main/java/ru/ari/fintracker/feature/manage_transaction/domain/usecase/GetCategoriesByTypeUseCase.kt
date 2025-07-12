package ru.ari.fintracker.feature.manage_transaction.domain.usecase

import ru.ari.fintracker.feature.categories.domain.repository.CategoriesRepository
import javax.inject.Inject

class GetCategoriesByTypeUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) {
    suspend operator fun invoke(isIncome: Boolean) =
        categoriesRepository.getCategoriesByType(isIncome)
}