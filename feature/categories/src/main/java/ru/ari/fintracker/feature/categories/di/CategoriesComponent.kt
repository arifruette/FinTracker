package ru.ari.fintracker.feature.categories.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import ru.ari.fintracker.core.di.component.CoreComponentDeps
import ru.ari.fintracker.feature.categories.data.di.CategoriesNetworkModule
import ru.ari.fintracker.feature.categories.data.di.CategoriesRepositoryModule

@CategoriesScope
@Component(
    dependencies = [CoreComponentDeps::class],
    modules = [
        CategoriesNetworkModule::class,
        CategoriesRepositoryModule::class,
        CategoriesViewModelModule::class
    ]
)
interface CategoriesComponent {
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            deps: CoreComponentDeps
        ): CategoriesComponent
    }
}
