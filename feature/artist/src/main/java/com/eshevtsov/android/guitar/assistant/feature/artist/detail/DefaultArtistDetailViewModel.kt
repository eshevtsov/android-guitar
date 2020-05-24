package com.eshevtsov.android.guitar.assistant.feature.artist.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eshevtsov.android.guitar.assistant.core.feature.error.exceptionHandler
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistInteractor
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.LinkModel
import kotlinx.coroutines.launch

class DefaultArtistDetailViewModel(
    private val artistInteractor: ArtistInteractor
) : ArtistDetailViewModel() {

    override val errorEvent = SingleLiveEvent<String>()
    override val title = MutableLiveData<String>()
    override val iconUri = MutableLiveData<String>()
    override val linkList = MutableLiveData<List<LinkModel>>()

    override fun loadDetails(artistId: Long) {
        viewModelScope.launch(exceptionHandler) {
            val artist = artistInteractor.getDetail(artistId)
            title.postValue(artist.name)
            artist.imageUri?.let(iconUri::postValue)
            linkList.postValue(artist.links)
        }
    }
}