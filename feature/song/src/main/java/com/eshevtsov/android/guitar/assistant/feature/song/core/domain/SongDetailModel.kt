package com.eshevtsov.android.guitar.assistant.feature.song.core.domain

data class SongDetailModel(
    val id: Long,
    val artistId: Long,
    val albumId: Long,
    val name: String,
    val artistName: String,
    val albumName: String,
    val albumCoverUri: String? = null,
    val timeMilliseconds: Long? = null,
    val text: String? = null,
    val numberInAlbum: Int? = null
)