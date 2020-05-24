package com.eshevtsov.android.guitar.assistant.feature.artist.core.domain

interface ArtistInteractor {
    suspend fun getList(): List<ArtistListItemModel>
}