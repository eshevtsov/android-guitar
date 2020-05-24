package com.eshevtsov.android.guitar.assistant.feature.album.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.SongNameDto
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.SongListItemModel

interface SongEntityToModelMapper {
    operator fun invoke(entity: SongNameDto): SongListItemModel
}