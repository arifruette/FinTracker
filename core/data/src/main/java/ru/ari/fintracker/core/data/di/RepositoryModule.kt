package ru.ari.fintracker.core.data.di

import dagger.Binds
import dagger.Module
import ru.ari.fintracker.core.common.utils.qualifiers.AppScope
import ru.ari.fintracker.core.data.repository.AccountRepositoryImpl
import ru.ari.fintracker.core.data.repository.TransactionRepositoryImpl
import ru.ari.fintracker.core.domain.repository.AccountRepository
import ru.ari.fintracker.core.domain.repository.TransactionRepository

@Module
interface RepositoryModule {

    @AppScope
    @Binds
    fun bindAccountRepositoryImpl(accountRepositoryImpl: AccountRepositoryImpl): AccountRepository

    @AppScope
    @Binds
    fun bindTransactionRepositoryImpl(transactionRepositoryImpl: TransactionRepositoryImpl): TransactionRepository
}