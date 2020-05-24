package com.eshevtsov.android.guitar.assistant.feature.artist.core.domain

data class ArtistListItemModel(
    val id: Long,
    val title: String,
    val information: String,
    val imageUri: String? = null
)