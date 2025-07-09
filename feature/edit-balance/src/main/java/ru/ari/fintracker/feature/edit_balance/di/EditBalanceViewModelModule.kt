package ru.ari.fintracker.feature.edit_balance.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.ari.fintracker.core.di.viewmodel.DaggerViewModelFactory
import ru.ari.fintracker.core.di.viewmodel.ViewModelKey
import ru.ari.fintracker.feature.edit_balance.ui.viewmodel.EditBalanceViewModel

@Module
interface EditBalanceViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EditBalanceViewModel::class)
    fun bindCategoriesViewModel(viewModel: EditBalanceViewModel): ViewModel

    @Binds
    fun bindFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}
