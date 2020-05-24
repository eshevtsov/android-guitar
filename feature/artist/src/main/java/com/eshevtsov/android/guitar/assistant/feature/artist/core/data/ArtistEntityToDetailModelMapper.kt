package com.eshevtsov.android.guitar.assistant.feature.artist.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.ArtistWithLinksDto
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistDetailModel

interface ArtistEntityToDetailModelMapper {
    operator fun invoke(entity: ArtistWithLinksDto): ArtistDetailModel
}