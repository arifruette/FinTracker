package ru.ari.fintracker.feature.categories.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.ari.fintracker.feature.categories.data.api.CategoriesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CategoriesNetworkModule {

    @Provides
    @Singleton
    fun provideCategoriesApi(retrofit: Retrofit) = retrofit.create(CategoriesApi::class.java)
}