package com.eshevtsov.android.guitar.assistant.feature.song.core.domain

data class SongListItemModel(
    val id: Long,
    val name: String,
    val artistName: String,
    val coverUri: String? = null
)