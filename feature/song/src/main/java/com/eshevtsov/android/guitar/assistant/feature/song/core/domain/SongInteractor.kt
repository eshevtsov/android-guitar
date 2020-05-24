package com.eshevtsov.android.guitar.assistant.feature.song.core.domain

interface SongInteractor {
    suspend fun getList(): List<SongListItemModel>
}