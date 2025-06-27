package ru.ari.fintracker.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Основной класс приложения, инициализирующий компоненты Hilt для Dependency Injection.
 */
@HiltAndroidApp
class FinTrackerApplication: Application()
