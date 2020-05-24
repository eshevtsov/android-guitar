package com.eshevtsov.android.guitar.assistant.feature.song.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eshevtsov.android.guitar.assistant.core.feature.error.exceptionHandler
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongInteractor
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongListItemModel
import kotlinx.coroutines.launch

class DefaultSongListViewModel(
    private val songInteractor: SongInteractor
) : SongListViewModel() {
    override val errorEvent = SingleLiveEvent<String>()
    override val songList = MutableLiveData<List<SongListItemModel>>()

    init {
        viewModelScope.launch(exceptionHandler) {
            songList.postValue(songInteractor.getList())
        }
    }
}