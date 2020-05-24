package com.eshevtsov.android.guitar.assistant.feature.album.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.AlbumDetailsDto
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumDetailModel

class DefaultAlbumEntityToDetailModelMapper(
    private val mapSongEntityToModel: SongEntityToModelMapper
) : AlbumEntityToDetailModelMapper {

    override operator fun invoke(entity: AlbumDetailsDto) =
        AlbumDetailModel(
            name = entity.album.name,
            year = entity.album.year,
            coverUri = entity.album.coverUri,
            artistName = entity.artist.name,
            songs = entity.songs.map(mapSongEntityToModel::invoke)
        )
}