package ru.ari.fintracker.feature.history.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import ru.ari.fintracker.core.di.component.CoreComponentDeps

@HistoryScope
@Component(
    dependencies = [CoreComponentDeps::class],
    modules = [
        HistoryViewModelModule::class
    ]
)
interface HistoryComponent {
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            deps: CoreComponentDeps
        ): HistoryComponent
    }
}
