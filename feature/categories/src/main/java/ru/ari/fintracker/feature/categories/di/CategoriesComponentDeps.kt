package ru.ari.fintracker.feature.categories.di

import ru.ari.fintracker.feature.categories.domain.repository.CategoriesRepository

interface CategoriesComponentDeps {
    fun categoriesRepository(): CategoriesRepository
}
