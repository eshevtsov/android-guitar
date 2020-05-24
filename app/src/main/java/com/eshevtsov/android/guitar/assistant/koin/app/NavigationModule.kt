package com.eshevtsov.android.guitar.assistant.koin.app

import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.album.core.ui.AlbumNavigation
import com.eshevtsov.android.guitar.assistant.feature.artist.core.ui.ArtistNavigation
import com.eshevtsov.android.guitar.assistant.feature.login.ui.LoginNavigation
import com.eshevtsov.android.guitar.assistant.feature.song.core.ui.SongNavigation
import com.eshevtsov.android.guitar.assistant.navigation.*
import org.koin.dsl.module

object NavigationModule {
    val default = module {
        single<AppNavigator> { DefaultAppNavigator() }
        single<ErrorNavigation> { get<AppNavigator>() }
        single<LoginNavigation> { DefaultLoginNavigation(get()) }
        single<ArtistNavigation> { DefaultArtistNavigation(get()) }
        single<AlbumNavigation> { DefaultAlbumNavigation(get()) }
        single<SongNavigation> { DefaultSongNavigation(get()) }
    }
}