package com.eshevtsov.android.guitar.assistant.koin

import com.eshevtsov.android.guitar.assistant.koin.app.AppModule
import com.eshevtsov.android.guitar.assistant.koin.app.NavigationModule
import com.eshevtsov.android.guitar.assistant.koin.feature.LoginModule
import org.koin.core.module.Module

object KoinModules {
    val list: List<Module> = listOf(
        AppModule.default,
        NavigationModule.default,
        LoginModule.default
    )
}