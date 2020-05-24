package com.eshevtsov.android.guitar.assistant.feature.album.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.AlbumDetailsDto
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumDetailModel

interface AlbumEntityToDetailModelMapper {
    operator fun invoke(entity: AlbumDetailsDto): AlbumDetailModel
}