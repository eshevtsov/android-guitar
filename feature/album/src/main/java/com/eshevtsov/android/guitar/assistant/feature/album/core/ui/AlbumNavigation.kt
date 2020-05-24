package com.eshevtsov.android.guitar.assistant.feature.album.core.ui

import android.view.View
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation

interface AlbumNavigation : ErrorNavigation {
    fun toAlbumDetail(view: View, albumId: Long)
}