package ru.ari.fintracker.core.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.ari.fintracker.core.data.api.TransactionApi
import ru.ari.fintracker.core.data.repository.TransactionRepositoryImpl
import ru.ari.fintracker.core.domain.repository.TransactionRepository

/**
 * Hilt-модуль для предоставления зависимостей, связанных с транзакциями.
 * ### Предоставляемые зависимости:
 * 1. [TransactionApi] - Retrofit-интерфейс для сетевых запросов
 * 2. [TransactionRepository] - репозиторий для бизнес-логики работы с транзакциями
 */
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
