package ru.ari.fintracker.feature.balance.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.ari.fintracker.core.di.viewmodel.DaggerViewModelFactory
import ru.ari.fintracker.core.di.viewmodel.ViewModelKey
import ru.ari.fintracker.feature.balance.ui.viewmodel.BalanceViewModel

@Module
interface BalanceViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BalanceViewModel::class)
    fun bindBalanceViewModel(
        viewModel: BalanceViewModel
    ): ViewModel

    @Binds
    fun bindFactory(
        factory: DaggerViewModelFactory
    ): ViewModelProvider.Factory
}
