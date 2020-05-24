package com.eshevtsov.android.guitar.assistant.feature.artist.domain

import com.eshevtsov.android.guitar.assistant.feature.artist.domain.ArtistListItemModel

interface ArtistRepository {
    suspend fun getList(userId: Long): List<ArtistListItemModel>
}