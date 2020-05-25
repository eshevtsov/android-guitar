package com.eshevtsov.android.guitar.assistant.navigation

import android.view.View
import androidx.core.os.bundleOf
import com.eshevtsov.android.guitar.assistant.R
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.album.core.ui.AlbumNavigation
import com.eshevtsov.android.guitar.assistant.feature.song.detail.SongDetailContract

class DefaultAlbumNavigation(
    private val appNavigator: AppNavigator
) : AlbumNavigation, ErrorNavigation by appNavigator {

    override fun toSongDetail(view: View, songId: Long) {
        val arguments = bundleOf(SongDetailContract.SONG_ID_EXTRA to songId)
        appNavigator.navigate(view, R.id.action_album_detail_to_song_detail, arguments)
    }
}