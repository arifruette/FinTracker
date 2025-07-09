package ru.ari.fintracker.feature.edit_balance.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import ru.ari.fintracker.core.di.component.CoreComponentDeps

@EditBalanceScope
@Component(
    dependencies = [CoreComponentDeps::class],
    modules = [
        EditBalanceViewModelModule::class
    ]
)
interface EditBalanceComponent {
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            deps: CoreComponentDeps
        ): EditBalanceComponent
    }
}
