package ru.ari.fintracker.feature.income.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.ari.fintracker.core.di.viewmodel.DaggerViewModelFactory
import ru.ari.fintracker.core.di.viewmodel.ViewModelKey
import ru.ari.fintracker.feature.income.ui.viewmodel.IncomeViewModel

@Module
interface IncomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(IncomeViewModel::class)
    fun bindIncomeViewModel(
        viewModel: IncomeViewModel
    ): ViewModel

    @Binds
    fun bindFactory(
        factory: DaggerViewModelFactory
    ): ViewModelProvider.Factory
}
