package com.eshevtsov.android.guitar.assistant.navigation

import android.view.View
import androidx.core.os.bundleOf
import com.eshevtsov.android.guitar.assistant.R
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.album.core.ui.AlbumNavigation
import com.eshevtsov.android.guitar.assistant.feature.album.detail.AlbumDetailContract

class DefaultAlbumNavigation(
    private val appNavigator: AppNavigator
) : AlbumNavigation, ErrorNavigation by appNavigator {

    override fun toAlbumDetail(view: View, albumId: Long) {
        val arguments = bundleOf(AlbumDetailContract.ALBUM_ID_EXTRA to albumId)
        appNavigator.navigate(view, R.id.action_album_list_to_detail, arguments)
    }
}