package ru.ari.fintracker.core.di.component

import dagger.BindsInstance
import dagger.Component
import ru.ari.fintracker.core.common.utils.qualifiers.AppScope
import ru.ari.fintracker.core.data.di.AccountModule
import ru.ari.fintracker.core.data.di.RepositoryModule
import ru.ari.fintracker.core.data.di.TransactionModule
import ru.ari.fintracker.core.di.modules.UseCasesModule
import ru.ari.fintracker.core.network.di.NetworkModule

@AppScope
@Component(
    modules = [
        NetworkModule::class,
        AccountModule::class,
        TransactionModule::class,
        RepositoryModule::class,
        UseCasesModule::class
    ]
)
interface CoreComponent : CoreComponentDeps {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance apiKey: String
        ): CoreComponent
    }
}
