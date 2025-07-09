package ru.ari.fintracker.feature.categories.data.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.ari.fintracker.feature.categories.data.api.CategoriesApi
import ru.ari.fintracker.feature.categories.di.CategoriesScope

@Module
class CategoriesNetworkModule {

    @Provides
    @CategoriesScope
    fun provideCategoriesApi(retrofit: Retrofit): CategoriesApi = retrofit.create(CategoriesApi::class.java)
}