package ru.ari.fintracker.feature.expenses.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import ru.ari.fintracker.core.di.component.CoreComponentDeps

@ExpensesScope
@Component(
    dependencies = [CoreComponentDeps::class],
    modules = [
        ExpensesViewModelModule::class
    ]
)
interface ExpensesComponent {
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            deps: CoreComponentDeps
        ): ExpensesComponent
    }
}
