package ru.ari.fintracker.core.di.modules

import dagger.Module
import dagger.Provides
import ru.ari.fintracker.core.common.utils.qualifiers.AppScope
import ru.ari.fintracker.core.domain.repository.AccountRepository
import ru.ari.fintracker.core.domain.usecase.GetAccountInfoUseCase

@Module
class UseCasesModule {

    @Provides
    @AppScope
    fun provideGetAccountInfoUseCase(
        accountRepository: AccountRepository
    ): GetAccountInfoUseCase = GetAccountInfoUseCase(accountRepository)
}
