package com.eshevtsov.android.guitar.assistant.feature.artist.data

import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity
import com.eshevtsov.android.guitar.assistant.feature.artist.domain.ArtistListItemModel

interface ArtistEntityToListModelMapper {
    operator fun invoke(
        entity: ArtistEntity,
        albumsCount: Long,
        songsCount: Long
    ): ArtistListItemModel
}