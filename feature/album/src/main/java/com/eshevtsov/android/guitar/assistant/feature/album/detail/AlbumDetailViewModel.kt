package com.eshevtsov.android.guitar.assistant.feature.album.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorSource
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.SongListItemModel

abstract class AlbumDetailViewModel : ViewModel(), ErrorSource {
    abstract val title: LiveData<String>
    abstract val year: LiveData<String>
    abstract val artistName: LiveData<String>
    abstract val coverUri: LiveData<String>
    abstract val songList: LiveData<List<SongListItemModel>>

    abstract fun loadDetails(albumId: Long)
}