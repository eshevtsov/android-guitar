package com.eshevtsov.android.guitar.assistant.feature.artist.core.domain

interface ArtistRepository {
    suspend fun getList(userId: Long): List<ArtistListItemModel>
}