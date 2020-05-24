package com.eshevtsov.android.guitar.assistant.feature.album.core.domain

data class AlbumDetailModel(
    val name: String,
    val artistName: String,
    val year: Int? = null,
    val coverUri: String? = null,
    val songs: List<SongListItemModel> = emptyList()
)