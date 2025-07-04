package ru.ari.fintracker.feature.categories.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ari.fintracker.feature.categories.data.repository.CategoriesRepositoryImpl
import ru.ari.fintracker.feature.categories.domain.repository.CategoriesRepository


/**
 * Модуль для DI связанного с репозиторием категорий
 */
@Module
@InstallIn(SingletonComponent::class)
interface CategoriesRepositoryModule {

    @Binds
    fun bindCategoriesRepositoryImpl(repositoryImpl: CategoriesRepositoryImpl): CategoriesRepository
}
