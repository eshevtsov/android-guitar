package com.eshevtsov.android.guitar.assistant.feature.album.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eshevtsov.android.guitar.assistant.core.feature.error.exceptionHandler
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumInteractor
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.SongListItemModel
import kotlinx.coroutines.launch

class DefaultAlbumDetailViewModel(
    private val albumInteractor: AlbumInteractor
) : AlbumDetailViewModel() {

    override val errorEvent = SingleLiveEvent<String>()
    override val title = MutableLiveData<String>()
    override val year = MutableLiveData<String>()
    override val artistName = MutableLiveData<String>()
    override val coverUri = MutableLiveData<String>()
    override val songList = MutableLiveData<List<SongListItemModel>>()

    override fun loadDetails(albumId: Long) {
        viewModelScope.launch(exceptionHandler) {
            val album = albumInteractor.getDetails(albumId)
            title.postValue(album.name)
            artistName.postValue(album.artistName)
            songList.postValue(album.songs)
            album.year?.toString()?.let(year::postValue)
            album.coverUri?.let(coverUri::postValue)
        }
    }
}