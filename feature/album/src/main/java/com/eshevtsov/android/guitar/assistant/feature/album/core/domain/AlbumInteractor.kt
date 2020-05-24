package com.eshevtsov.android.guitar.assistant.feature.album.core.domain

interface AlbumInteractor {
    suspend fun getAll(artistId: Long): List<AlbumListItemModel>
}