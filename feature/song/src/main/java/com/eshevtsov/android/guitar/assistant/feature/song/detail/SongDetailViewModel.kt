package com.eshevtsov.android.guitar.assistant.feature.song.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorSource

abstract class SongDetailViewModel : ViewModel(), ErrorSource {
    abstract val name: LiveData<String>
    abstract val artistName: LiveData<String>
    abstract val albumCoverUri: LiveData<String>
    abstract val text: LiveData<String>

    abstract fun loadDetails(songId: Long)
}