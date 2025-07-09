package ru.ari.fintracker.feature.balance.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import ru.ari.fintracker.core.di.component.CoreComponentDeps

@BalanceScope
@Component(
    dependencies = [CoreComponentDeps::class],
    modules = [
        BalanceViewModelModule::class
    ]
)
interface BalanceComponent {
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            deps: CoreComponentDeps
        ): BalanceComponent
    }
}
