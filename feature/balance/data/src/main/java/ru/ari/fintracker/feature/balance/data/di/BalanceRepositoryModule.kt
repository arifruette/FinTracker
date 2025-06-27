package ru.ari.fintracker.feature.balance.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ari.fintracker.feature.balance.data.repository.FakeBalanceRepositoryImpl
import ru.ari.fintracker.feature.balance.domain.repository.BalanceRepository

@Module
@InstallIn(SingletonComponent::class)
interface BalanceRepositoryModule {

    @Binds
    fun bindBalanceRepositoryImpl(repositoryImpl: FakeBalanceRepositoryImpl): BalanceRepository
}
