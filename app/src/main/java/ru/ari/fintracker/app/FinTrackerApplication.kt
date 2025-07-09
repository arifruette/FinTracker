package ru.ari.fintracker.app

import android.app.Application
import ru.ari.fintracker.BuildConfig
import ru.ari.fintracker.core.di.component.CoreComponent
import ru.ari.fintracker.core.di.component.CoreComponentProvider
import ru.ari.fintracker.core.di.component.DaggerCoreComponent

class FinTrackerApplication: Application(), CoreComponentProvider {

    override lateinit var coreComponent: CoreComponent
        private set

    override fun onCreate() {
        super.onCreate()

        coreComponent = DaggerCoreComponent.factory()
            .create(BuildConfig.API_KEY)
    }
}