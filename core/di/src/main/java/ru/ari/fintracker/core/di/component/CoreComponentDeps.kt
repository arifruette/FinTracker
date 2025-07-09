package ru.ari.fintracker.core.di.component

import retrofit2.Retrofit
import ru.ari.fintracker.core.domain.repository.AccountRepository
import ru.ari.fintracker.core.domain.repository.TransactionRepository
import ru.ari.fintracker.core.domain.usecase.GetAccountInfoUseCase

interface CoreComponentDeps {
    fun accountRepository(): AccountRepository
    fun transactionRepository(): TransactionRepository
    fun getAccountInfoUseCase(): GetAccountInfoUseCase
    fun retrofit(): Retrofit
}
