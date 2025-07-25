package ru.ari.fintracker.feature.categories.data.repository

import retrofit2.HttpException
import ru.ari.fintracker.core.common.utils.Result
import ru.ari.fintracker.core.domain.models.transaction.Category
import ru.ari.fintracker.feature.categories.data.api.CategoriesApi
import ru.ari.fintracker.feature.categories.data.mapper.toDomain
import ru.ari.fintracker.feature.categories.domain.repository.CategoriesRepository
import javax.inject.Inject

/**
 * Репозиторий для получения категорий
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

    override suspend fun getCategoriesByType(isIncome: Boolean): Result<List<Category>> {
        return try {
            val resp = categoriesApi.getCategoriesByType(isIncome)
            Result.Success(resp.body()?.map { it.toDomain() } ?: emptyList())
        } catch(e: HttpException) {
            Result.Error(e.code(), e.message())
        } catch (e: Throwable) {
            Result.Exception(e)
        }
    }
}
