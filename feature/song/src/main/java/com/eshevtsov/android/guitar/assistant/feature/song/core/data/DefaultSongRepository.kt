package com.eshevtsov.android.guitar.assistant.feature.song.core.data

import com.eshevtsov.android.guitar.assistant.database.dao.UserArtistDao
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongDetailModel
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongListItemModel
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongRepository
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.take

class DefaultSongRepository(
    private val userArtistDao: UserArtistDao,
    private val mapArtistEntityToSongListModel: ArtistEntityToSongListModelMapper
) : SongRepository {

    override suspend fun getAll(userId: Long): List<SongListItemModel> {
        val userArtistWithSongs = userArtistDao.getArtistWithAlbumsList(userId)
            .take(1)
            .single()
        return userArtistWithSongs.artistList.map(mapArtistEntityToSongListModel::invoke)
            .fold(mutableListOf()) { acc, list ->
                acc.apply { addAll(list) }
            }
    }

    override suspend fun getDetail(songId: Long): SongDetailModel {
        return SongDetailModel(songId)
    }
}