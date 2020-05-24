package com.eshevtsov.android.guitar.assistant.feature.artist.core.ui

import android.view.View
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation

interface ArtistNavigation : ErrorNavigation {
    fun toArtistDetail(view: View, artistId: Long)
    fun toAlbumDetail(view: View, albumId: Long)
}