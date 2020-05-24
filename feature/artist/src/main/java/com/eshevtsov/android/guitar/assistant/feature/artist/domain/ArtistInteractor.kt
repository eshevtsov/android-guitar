package com.eshevtsov.android.guitar.assistant.feature.artist.domain

interface ArtistInteractor {
    suspend fun getList(): List<ArtistListItemModel>
}