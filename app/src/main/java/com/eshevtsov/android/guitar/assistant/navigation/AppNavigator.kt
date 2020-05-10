package com.eshevtsov.android.guitar.assistant.navigation

import androidx.annotation.IdRes
import androidx.navigation.NavController

interface AppNavigator {
    fun bind(navController: NavController)
    fun unbind()
    fun navigate(@IdRes destinationId: Int)
}