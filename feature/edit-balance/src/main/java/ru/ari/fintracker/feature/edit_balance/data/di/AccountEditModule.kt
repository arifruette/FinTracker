package ru.ari.fintracker.feature.edit_balance.data.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.ari.fintracker.feature.edit_balance.data.api.AccountEditApi
import ru.ari.fintracker.feature.edit_balance.data.repository.AccountEditRepositoryImpl
import ru.ari.fintracker.feature.edit_balance.di.EditBalanceScope
import ru.ari.fintracker.feature.edit_balance.domain.repository.AccountEditRepository

@Module
class AccountEditModule {

    @Provides
    @EditBalanceScope
    fun provideAccountEditApi(retrofit: Retrofit) = retrofit.create(AccountEditApi::class.java)

    @Provides
    @EditBalanceScope
    fun provideAccountEditRepositoryImpl(api: AccountEditApi): AccountEditRepository =
        AccountEditRepositoryImpl(api)
}