package ru.ari.fintracker.feature.categories.data.api

import retrofit2.Response
import retrofit2.http.GET
import ru.ari.fintracker.feature.categories.data.models.CategoryResponse

interface CategoriesApi {

    @GET("categories")
    suspend fun getAllCategories(): Response<List<CategoryResponse>>
}