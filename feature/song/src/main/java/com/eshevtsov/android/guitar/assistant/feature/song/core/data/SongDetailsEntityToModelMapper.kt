package com.eshevtsov.android.guitar.assistant.feature.song.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.SongDetailsDto
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongDetailModel

interface SongDetailsEntityToModelMapper {
    operator fun invoke(entity: SongDetailsDto): SongDetailModel
}