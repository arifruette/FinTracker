package ru.ari.fintracker.feature.categories.data.repository

import retrofit2.HttpException
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.Category
import ru.ari.fintracker.feature.categories.data.api.CategoriesApi
import ru.ari.fintracker.feature.categories.data.mapper.toDomain
import ru.ari.fintracker.feature.categories.domain.repository.CategoriesRepository
import javax.inject.Inject

/**
 * Mock репозиторий для получения категорий
 */
class CategoriesRepositoryImpl @Inject constructor(
    private val categoriesApi: CategoriesApi
) : CategoriesRepository {
    override suspend fun getCategories(): Result<List<Category>> {
        return try {
            Result.Success(categoriesApi.getAllCategories().body()?.map { it.toDomain() }
                ?: emptyList())
        } catch (e: HttpException) {
            Result.Error(e.code(), e.message())
        } catch (e: Throwable) {
            Result.Exception(e)
        }
    }
}
