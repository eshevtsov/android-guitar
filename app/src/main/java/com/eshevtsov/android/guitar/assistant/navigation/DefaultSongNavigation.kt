package com.eshevtsov.android.guitar.assistant.navigation

import android.view.View
import androidx.core.os.bundleOf
import com.eshevtsov.android.guitar.assistant.R
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.song.core.ui.SongNavigation
import com.eshevtsov.android.guitar.assistant.feature.song.detail.SongDetailContract

class DefaultSongNavigation(
    private val appNavigator: AppNavigator
) : SongNavigation, ErrorNavigation by appNavigator {

    override fun toSongDetail(view: View, songId: Long) {
        val arguments = bundleOf(SongDetailContract.SONG_ID_EXTRA to songId)
        appNavigator.navigate(view, R.id.action_song_list_to_detail, arguments)
    }
}