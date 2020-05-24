package com.eshevtsov.android.guitar.assistant.feature.artist.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorSource
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.LinkModel

abstract class ArtistDetailViewModel : ViewModel(), ErrorSource {
    abstract val title: LiveData<String>
    abstract val iconUri: LiveData<String>
    abstract val linkList: LiveData<List<LinkModel>>
    abstract val navigateToAlbumListEvent: SingleLiveEvent<Long>

    abstract fun onAlbumsButtonCLicked()
    abstract fun loadDetails(artistId: Long)
}