package com.eshevtsov.android.guitar.assistant.feature.artist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorSource
import com.eshevtsov.android.guitar.assistant.feature.artist.domain.ArtistListItemModel

abstract class ArtistListViewModel : ViewModel(), ErrorSource {
    abstract val artistList: LiveData<List<ArtistListItemModel>>
}