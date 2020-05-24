package com.eshevtsov.android.guitar.assistant.navigation

import android.view.View
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.song.core.ui.SongNavigation

class DefaultSongNavigation(
    private val appNavigator: AppNavigator
) : SongNavigation, ErrorNavigation by appNavigator {

    override fun toSongDetail(view: View, songId: Long) {

    }
}