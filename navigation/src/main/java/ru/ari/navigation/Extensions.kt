package ru.ari.navigation

import ru.ari.ui.navigation.Screen

fun Screen.getRouteName(): String {
    return this::class.java.canonicalName.orEmpty()
}