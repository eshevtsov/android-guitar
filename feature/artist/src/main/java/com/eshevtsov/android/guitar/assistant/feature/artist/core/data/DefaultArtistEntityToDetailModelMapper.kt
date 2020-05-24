package com.eshevtsov.android.guitar.assistant.feature.artist.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.ArtistWithLinksDto
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistDetailModel

class DefaultArtistEntityToDetailModelMapper(
    private val mapLinkEntityToModel: LinkEntityToModelMapper
) : ArtistEntityToDetailModelMapper {

    override operator fun invoke(entity: ArtistWithLinksDto) =
        ArtistDetailModel(
            id = entity.artist.id,
            name = entity.artist.name,
            imageUri = entity.artist.imageUri,
            links = entity.links.map(mapLinkEntityToModel::invoke)
        )
}