package com.eshevtsov.android.guitar.assistant.feature.album.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.SongNameDto
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.SongListItemModel

class DefaultSongEntityToModelMapper : SongEntityToModelMapper {

    override operator fun invoke(entity: SongNameDto) =
        SongListItemModel(
            id = entity.id,
            name = entity.name,
            numberInAlbum = entity.numberInAlbum
        )
}