package ru.ari.fintracker.core.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.ari.fintracker.core.data.api.AccountApi
import ru.ari.fintracker.core.data.repository.AccountRepositoryImpl
import ru.ari.fintracker.core.domain.repository.AccountRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AccountModule {

    @Provides
    @Singleton
    fun provideAccountApi(retrofit: Retrofit) = retrofit.create(AccountApi::class.java)

    @Provides
    @Singleton
    fun provideAccountRepositoryImpl(api: AccountApi): AccountRepository = AccountRepositoryImpl(api)
}