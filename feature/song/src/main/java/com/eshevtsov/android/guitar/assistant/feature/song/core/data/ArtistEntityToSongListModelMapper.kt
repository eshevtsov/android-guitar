package com.eshevtsov.android.guitar.assistant.feature.song.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.ArtistWithAlbumsDto
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongListItemModel

interface ArtistEntityToSongListModelMapper {
    operator fun invoke(artist: ArtistWithAlbumsDto): List<SongListItemModel>
}