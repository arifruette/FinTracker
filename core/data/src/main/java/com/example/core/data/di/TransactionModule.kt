package com.example.core.data.di

import com.example.core.data.api.TransactionApi
import com.example.core.data.repository.TransactionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.ari.core.domain.repository.TransactionRepository


@Module
@InstallIn(SingletonComponent::class)
class TransactionModule {

    @Provides
    fun provideTransactionsApi(
        retrofit: Retrofit
    ): TransactionApi = retrofit.create(TransactionApi::class.java)

    @Provides
    fun provideTransactionRepository(
        api: TransactionApi
    ): TransactionRepository = TransactionRepositoryImpl(api)
}
