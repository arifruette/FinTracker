package ru.ari.fintracker.feature.edit_balance.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.ari.fintracker.feature.edit_balance.data.api.AccountEditApi
import ru.ari.fintracker.feature.edit_balance.data.repository.AccountEditRepositoryImpl
import ru.ari.fintracker.feature.edit_balance.domain.repository.AccountEditRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AccountEditModule {

    @Provides
    @Singleton
    fun provideAccountEditApi(retrofit: Retrofit) = retrofit.create(AccountEditApi::class.java)

    @Provides
    fun provideAccountEditRepositoryImpl(api: AccountEditApi): AccountEditRepository =
        AccountEditRepositoryImpl(api)
}