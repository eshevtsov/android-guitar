package com.eshevtsov.android.guitar.assistant.feature.artist.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eshevtsov.android.guitar.assistant.core.feature.error.exceptionHandler
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistInteractor
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistListItemModel
import kotlinx.coroutines.launch

class DefaultArtistListViewModel(
    private val artistInteractor: ArtistInteractor
) : ArtistListViewModel() {
    override val errorEvent = SingleLiveEvent<String>()
    override val artistList = MutableLiveData<List<ArtistListItemModel>>()

    init {
        viewModelScope.launch(exceptionHandler) {
            artistList.postValue(artistInteractor.getList())
        }
    }
}