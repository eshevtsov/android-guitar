package com.eshevtsov.android.guitar.assistant.feature.song.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eshevtsov.android.guitar.assistant.core.feature.error.exceptionHandler
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongInteractor
import kotlinx.coroutines.launch

class DefaultSongDetailViewModel(
    private val songInteractor: SongInteractor
) : SongDetailViewModel() {

    override val errorEvent = SingleLiveEvent<String>()
    override val name = MutableLiveData<String>()
    override val albumCoverUri = MutableLiveData<String>()
    override val artistName = MutableLiveData<String>()
    override val text = MutableLiveData<String>()

    override fun loadDetails(songId: Long) {
        viewModelScope.launch(exceptionHandler) {
            val song = songInteractor.getDetail(songId)
            name.postValue(song.name)
            artistName.postValue(song.artistName)
            text.postValue(song.text)
            song.albumCoverUri?.let(albumCoverUri::postValue)
        }
    }
}