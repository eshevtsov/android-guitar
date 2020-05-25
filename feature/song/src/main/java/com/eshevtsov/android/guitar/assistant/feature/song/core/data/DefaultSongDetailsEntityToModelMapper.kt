package com.eshevtsov.android.guitar.assistant.feature.song.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.SongDetailsDto
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongDetailModel

class DefaultSongDetailsEntityToModelMapper : SongDetailsEntityToModelMapper {

    override operator fun invoke(entity: SongDetailsDto) =
        SongDetailModel(
            id = entity.song.id,
            name = entity.song.name,
            timeMilliseconds = entity.song.timeMilliseconds,
            text = entity.song.text,
            numberInAlbum = entity.song.numberInAlbum,
            artistName = entity.albumWithArtist.artist.name,
            artistId = entity.albumWithArtist.artist.id,
            albumId = entity.albumWithArtist.album.id,
            albumCoverUri = entity.albumWithArtist.album.coverUri,
            albumName = entity.albumWithArtist.album.name
        )
}