package ru.ari.fintracker.core.data.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.ari.fintracker.core.common.utils.qualifiers.AppScope
import ru.ari.fintracker.core.data.api.TransactionApi


@Module
class TransactionModule {

    @AppScope
    @Provides
    fun provideTransactionsApi(
        retrofit: Retrofit
    ): TransactionApi = retrofit.create(TransactionApi::class.java)

}
