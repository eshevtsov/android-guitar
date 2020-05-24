package com.eshevtsov.android.guitar.assistant.feature.artist.core.domain

data class ArtistDetailModel(
    val id: Long,
    val name: String,
    val links: List<LinkModel> = emptyList(),
    val imageUri: String? = null
)