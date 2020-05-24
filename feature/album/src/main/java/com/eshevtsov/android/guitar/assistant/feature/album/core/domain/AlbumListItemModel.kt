package com.eshevtsov.android.guitar.assistant.feature.album.core.domain

data class AlbumListItemModel(
    val id: Long,
    val name: String,
    val year: Int? = null,
    val coverUri: String? = null
)