package ru.ari.fintracker.feature.categories.data.di

import dagger.Binds
import dagger.Module
import ru.ari.fintracker.feature.categories.data.repository.CategoriesRepositoryImpl
import ru.ari.fintracker.feature.categories.di.CategoriesScope
import ru.ari.fintracker.feature.categories.domain.repository.CategoriesRepository


/**
 * Модуль для DI связанного с репозиторием категорий
 */
@Module
interface CategoriesRepositoryModule {
    @Binds
    @CategoriesScope
    fun bindCategoriesRepositoryImpl(repositoryImpl: CategoriesRepositoryImpl): CategoriesRepository
}
