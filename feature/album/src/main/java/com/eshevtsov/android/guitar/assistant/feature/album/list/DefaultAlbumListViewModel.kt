package com.eshevtsov.android.guitar.assistant.feature.album.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eshevtsov.android.guitar.assistant.core.feature.error.exceptionHandler
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumInteractor
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumListItemModel
import kotlinx.coroutines.launch

class DefaultAlbumListViewModel(
    private val albumInteractor: AlbumInteractor
) : AlbumListViewModel() {
    override val errorEvent = SingleLiveEvent<String>()
    override val albumList = MutableLiveData<List<AlbumListItemModel>>()

    override fun loadAlbums(artistId: Long) {
        viewModelScope.launch(exceptionHandler) {
            val albums = albumInteractor.getAll(artistId)
            albumList.postValue(albums)
        }
    }
}