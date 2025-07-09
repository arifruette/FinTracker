package ru.ari.fintracker.feature.income.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import ru.ari.fintracker.core.di.component.CoreComponentDeps

@IncomeScope
@Component(
    dependencies = [CoreComponentDeps::class],
    modules = [
        IncomeViewModelModule::class
    ]
)
interface IncomeComponent {
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            deps: CoreComponentDeps
        ): IncomeComponent
    }
}
