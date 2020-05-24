package com.eshevtsov.android.guitar.assistant.feature.artist.data

import com.eshevtsov.android.guitar.assistant.core.feature.resource.StringProvider
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity
import com.eshevtsov.android.guitar.assistant.feature.artist.data.ArtistEntityToListModelMapper
import com.eshevtsov.android.guitar.assistant.feature.artist.domain.ArtistListItemModel

class DefaultArtistEntityToListModelMapper(
    private val stringProvider: StringProvider
) : ArtistEntityToListModelMapper {

    override operator fun invoke(
        entity: ArtistEntity,
        albumsCount: Long,
        songsCount: Long
    ) =
        ArtistListItemModel(
            id = entity.id,
            title = entity.name,
            information = stringProvider.artistListItemInformation(albumsCount, songsCount),
            imageUri = entity.imageUri
        )
}