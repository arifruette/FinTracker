package ru.ari.fintracker.feature.categories.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ari.fintracker.feature.categories.data.repository.FakeRepositoryImpl
import ru.ari.fintracker.feature.categories.domain.repository.CategoriesRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCategoriesRepositoryImpl(repositoryImpl: FakeRepositoryImpl): CategoriesRepository
}
