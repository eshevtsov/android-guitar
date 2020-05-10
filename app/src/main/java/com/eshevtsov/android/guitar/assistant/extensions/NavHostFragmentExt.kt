package com.eshevtsov.android.guitar.assistant.extensions

import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment

fun NavHostFragment.initWith(
    @NavigationRes graph: Int,
    @IdRes startDestination: Int,
    fragmentFactory: FragmentFactory
) {
    childFragmentManager.fragmentFactory = fragmentFactory
    navController.run {
        this.graph = navInflater.inflate(graph)
            .apply { this.startDestination = startDestination }
    }
}