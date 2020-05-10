package com.eshevtsov.android.guitar.assistant.koin.app

import com.eshevtsov.android.guitar.assistant.feature.login.LoginNavigation
import com.eshevtsov.android.guitar.assistant.navigation.AppNavigator
import com.eshevtsov.android.guitar.assistant.navigation.DefaultAppNavigator
import com.eshevtsov.android.guitar.assistant.navigation.DefaultLoginNavigation
import org.koin.dsl.module

object NavigationModule {
    val default = module {
        single<AppNavigator> { DefaultAppNavigator() }
        single<LoginNavigation> { DefaultLoginNavigation(get()) }
    }
}