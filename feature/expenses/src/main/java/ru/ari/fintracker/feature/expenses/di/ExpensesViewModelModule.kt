package ru.ari.fintracker.feature.expenses.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.ari.fintracker.core.di.viewmodel.DaggerViewModelFactory
import ru.ari.fintracker.core.di.viewmodel.ViewModelKey
import ru.ari.fintracker.feature.expenses.ui.viewmodel.ExpensesViewModel

@Module
interface ExpensesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ExpensesViewModel::class)
    fun bindExpensesViewModel(
        viewModel: ExpensesViewModel
    ): ViewModel

    @Binds
    fun bindFactory(
        factory: DaggerViewModelFactory
    ): ViewModelProvider.Factory
}
