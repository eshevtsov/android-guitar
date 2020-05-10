package com.eshevtsov.android.guitar.assistant.navigation

import androidx.annotation.IdRes
import androidx.navigation.NavController

class DefaultAppNavigator : AppNavigator {
    private var navController: NavController? = null

    override fun bind(navController: NavController) {
        this.navController = navController
    }

    override fun unbind() {
        this.navController = null
    }

    override fun navigate(@IdRes destinationId: Int) {
        navController?.navigate(destinationId)
    }
}