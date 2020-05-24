package com.eshevtsov.android.guitar.assistant.feature.album.core.domain

interface AlbumRepository {
    suspend fun getAll(artistId: Long): List<AlbumListItemModel>
    suspend fun getDetails(albumId: Long): AlbumDetailModel
}