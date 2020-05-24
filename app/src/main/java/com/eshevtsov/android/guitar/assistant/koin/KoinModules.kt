package com.eshevtsov.android.guitar.assistant.koin

import com.eshevtsov.android.guitar.assistant.koin.app.AppModule
import com.eshevtsov.android.guitar.assistant.koin.app.DatabaseModule
import com.eshevtsov.android.guitar.assistant.koin.app.NavigationModule
import com.eshevtsov.android.guitar.assistant.koin.app.UserEventModule
import com.eshevtsov.android.guitar.assistant.koin.feature.AlbumModule
import com.eshevtsov.android.guitar.assistant.koin.feature.ArtistModule
import com.eshevtsov.android.guitar.assistant.koin.feature.HomeModule
import com.eshevtsov.android.guitar.assistant.koin.feature.LoginModule
import org.koin.core.module.Module

object KoinModules {
    val list: List<Module> = listOf(
        AppModule.default,
        DatabaseModule.default,
        UserEventModule.default,
        NavigationModule.default,
        ArtistModule.default,
        AlbumModule.default,
        LoginModule.default,
        HomeModule.default
    )
}