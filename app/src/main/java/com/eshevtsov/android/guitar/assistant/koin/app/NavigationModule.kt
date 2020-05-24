package com.eshevtsov.android.guitar.assistant.koin.app

import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.artist.core.ui.ArtistNavigation
import com.eshevtsov.android.guitar.assistant.feature.login.ui.LoginNavigation
import com.eshevtsov.android.guitar.assistant.navigation.AppNavigator
import com.eshevtsov.android.guitar.assistant.navigation.DefaultAppNavigator
import com.eshevtsov.android.guitar.assistant.navigation.DefaultArtistNavigation
import com.eshevtsov.android.guitar.assistant.navigation.DefaultLoginNavigation
import org.koin.dsl.module

object NavigationModule {
    val default = module {
        single<AppNavigator> { DefaultAppNavigator() }
        single<ErrorNavigation> { get<AppNavigator>() }
        single<LoginNavigation> { DefaultLoginNavigation(get()) }
        single<ArtistNavigation> { DefaultArtistNavigation(get()) }
    }
}