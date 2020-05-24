package com.eshevtsov.android.guitar.assistant.feature.album.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorSource
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumListItemModel

abstract class AlbumListViewModel : ViewModel(), ErrorSource {
    abstract val albumList: LiveData<List<AlbumListItemModel>>

    abstract fun loadAlbums(artistId: Long)
}