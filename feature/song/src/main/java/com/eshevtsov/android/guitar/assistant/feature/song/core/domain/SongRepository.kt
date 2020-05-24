package com.eshevtsov.android.guitar.assistant.feature.song.core.domain

interface SongRepository {
    suspend fun getAll(userId: Long): List<SongListItemModel>
    suspend fun getDetail(songId: Long): SongDetailModel
}