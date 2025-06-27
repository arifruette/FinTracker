package ru.ari.fintracker.feature.categories.data.repository

import kotlinx.coroutines.delay
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.feature.categories.domain.models.Category
import ru.ari.fintracker.feature.categories.domain.repository.CategoriesRepository
import javax.inject.Inject

/**
 * Mock репозиторий для получения категорий
 */
class FakeRepositoryImpl @Inject constructor(

): CategoriesRepository {
    override suspend fun getCategories(): Result<List<Category>> {
        delay(MOCK_REPO_DELAY)
        return Result.Success(
            listOf(
                Category(id = 1, icon = "\uD83C\uDFE0", name = "Аренда квартиры"),
                Category(id = 2, icon = "\uD83D\uDC57", name = "Одежда"),
                Category(id = 3, icon = "\uD83D\uDC36", name = "На собачку"),
                Category(id = 4, icon = "\uD83D\uDC36", name = "На собачку"),
                Category(id = 5, icon = "РК", name = "Ремонт квартиры"),
                Category(id = 6, icon = "\uD83C\uDF6D", name = "Продукты"),
                Category(id = 7, icon = "\uD83C\uDFCB\uFE0F", name = "Спортзал"),
                Category(id = 8, icon = "\uD83D\uDC8A", name = "Медицина")
            )
        )
    }

    companion object {
        private const val MOCK_REPO_DELAY = 300L
    }
}
