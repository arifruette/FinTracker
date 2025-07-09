package ru.ari.fintracker.feature.categories.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.ari.fintracker.core.di.viewmodel.DaggerViewModelFactory
import ru.ari.fintracker.core.di.viewmodel.ViewModelKey
import ru.ari.fintracker.feature.categories.ui.viewmodel.CategoriesViewModel

@Module
interface CategoriesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    fun bindCategoriesViewModel(viewModel: CategoriesViewModel): ViewModel

    @Binds
    fun bindFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}
