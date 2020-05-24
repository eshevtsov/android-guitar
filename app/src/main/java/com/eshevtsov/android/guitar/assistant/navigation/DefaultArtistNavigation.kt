package com.eshevtsov.android.guitar.assistant.navigation

import android.view.View
import androidx.core.os.bundleOf
import com.eshevtsov.android.guitar.assistant.R
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.album.detail.AlbumDetailContract
import com.eshevtsov.android.guitar.assistant.feature.artist.core.ui.ArtistNavigation
import com.eshevtsov.android.guitar.assistant.feature.artist.detail.ArtistDetailContract

class DefaultArtistNavigation(
    private val appNavigator: AppNavigator
) : ArtistNavigation, ErrorNavigation by appNavigator {

    override fun toArtistDetail(view: View, artistId: Long) {
        val arguments = bundleOf(ArtistDetailContract.ARTIST_ID_EXTRA to artistId)
        appNavigator.navigate(view, R.id.action_artist_list_to_detail, arguments)
    }

    override fun toAlbumDetail(view: View, albumId: Long) {
        val arguments = bundleOf(AlbumDetailContract.ALBUM_ID_EXTRA to albumId)
        appNavigator.navigate(view, R.id.action_artist_detail_to_album_detail, arguments)
    }
}