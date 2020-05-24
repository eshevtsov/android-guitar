package com.eshevtsov.android.guitar.assistant.navigation

import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.album.core.ui.AlbumNavigation

class DefaultAlbumNavigation(
    private val appNavigator: AppNavigator
) : AlbumNavigation, ErrorNavigation by appNavigator