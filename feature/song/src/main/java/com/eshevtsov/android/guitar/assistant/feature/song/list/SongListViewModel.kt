package com.eshevtsov.android.guitar.assistant.feature.song.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorSource
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongListItemModel

abstract class SongListViewModel : ViewModel(), ErrorSource {
    abstract val songList: LiveData<List<SongListItemModel>>
}