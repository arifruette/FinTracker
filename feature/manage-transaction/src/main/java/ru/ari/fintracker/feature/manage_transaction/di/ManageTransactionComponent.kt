package ru.ari.fintracker.feature.manage_transaction.di

import dagger.Component
import ru.ari.fintracker.core.di.component.CoreComponentDeps
import ru.ari.fintracker.feature.categories.di.CategoriesComponentDeps
import ru.ari.fintracker.feature.manage_transaction.di.viewmodel.ViewModelAssistedFactory

@ManageTransactionScope
@Component(
    dependencies = [
        CategoriesComponentDeps::class, CoreComponentDeps::class,
    ]
)
interface ManageTransactionComponent {

    fun manageTransactionViewModelAssistedFactory(): ViewModelAssistedFactory

    @Component.Factory
    interface Factory {
        fun create(
            deps: CoreComponentDeps,
            categoriesDeps: CategoriesComponentDeps
        ): ManageTransactionComponent
    }
}
