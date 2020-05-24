package com.eshevtsov.android.guitar.assistant.feature.album.core.data

import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumListItemModel

interface AlbumEntityToListModelMapper {
    operator fun invoke(entity: AlbumEntity): AlbumListItemModel
}