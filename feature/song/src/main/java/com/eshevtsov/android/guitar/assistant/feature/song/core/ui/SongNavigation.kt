package com.eshevtsov.android.guitar.assistant.feature.song.core.ui

import android.view.View
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation

interface SongNavigation : ErrorNavigation {
    fun toSongDetail(view: View, songId: Long)
}