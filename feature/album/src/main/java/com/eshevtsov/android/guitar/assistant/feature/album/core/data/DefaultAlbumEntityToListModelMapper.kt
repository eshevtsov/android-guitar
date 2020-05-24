package com.eshevtsov.android.guitar.assistant.feature.album.core.data

import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumListItemModel

class DefaultAlbumEntityToListModelMapper : AlbumEntityToListModelMapper {
    override operator fun invoke(entity: AlbumEntity) =
        AlbumListItemModel(
            id = entity.id,
            name = entity.name,
            year = entity.year,
            coverUri = entity.coverUri
        )
}