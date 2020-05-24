package com.eshevtsov.android.guitar.assistant.feature.song.core.data

import com.eshevtsov.android.guitar.assistant.database.dto.ArtistWithAlbumsDto
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongListItemModel

class DefaultArtistEntityToSongListModelMapper : ArtistEntityToSongListModelMapper {

    override operator fun invoke(artist: ArtistWithAlbumsDto): List<SongListItemModel> =
        artist.albums.fold(mutableListOf()) { acc, album ->
            val songs = album.songs.map { song ->
                SongListItemModel(song.id, song.name, artist.name, album.coverUri)
            }
            acc.apply { addAll(songs) }
        }
}