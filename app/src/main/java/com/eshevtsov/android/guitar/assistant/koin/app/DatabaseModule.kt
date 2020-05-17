package com.eshevtsov.android.guitar.assistant.koin.app

import com.eshevtsov.android.guitar.assistant.database.GuitarAssistantDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseModule {
    val default = module {
        single { GuitarAssistantDatabase.get(androidContext()) }
        single { get<GuitarAssistantDatabase>().albumDao() }
        single { get<GuitarAssistantDatabase>().artistDao() }
        single { get<GuitarAssistantDatabase>().favouriteAlbumDao() }
        single { get<GuitarAssistantDatabase>().favouriteArtistDao() }
        single { get<GuitarAssistantDatabase>().favouriteSongDao() }
        single { get<GuitarAssistantDatabase>().linkDao() }
        single { get<GuitarAssistantDatabase>().songDao() }
        single { get<GuitarAssistantDatabase>().userArtistDao() }
        single { get<GuitarAssistantDatabase>().userDao() }
    }
}