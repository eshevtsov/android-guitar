package com.eshevtsov.android.guitar.assistant.feature.album.core.domain

data class SongListItemModel(
    val id: Long,
    val name: String,
    val numberInAlbum: Int? = null
)