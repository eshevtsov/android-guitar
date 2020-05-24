package com.eshevtsov.android.guitar.assistant.core.feature.resource

interface StringProvider {
    fun artistListItemInformation(albumsCount: Long, songsCount: Long): String
}