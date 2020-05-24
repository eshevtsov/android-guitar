package com.eshevtsov.android.guitar.assistant.feature.artist.core.data

import com.eshevtsov.android.guitar.assistant.database.dao.AlbumDao
import com.eshevtsov.android.guitar.assistant.database.dao.ArtistDao
import com.eshevtsov.android.guitar.assistant.database.dao.SongDao
import com.eshevtsov.android.guitar.assistant.database.dao.UserArtistDao
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistDetailModel
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistListItemModel
import com.eshevtsov.android.guitar.assistant.feature.artist.core.domain.ArtistRepository
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.take

class DefaultArtistRepository(
    private val userArtistDao: UserArtistDao,
    private val albumDao: AlbumDao,
    private val songDao: SongDao,
    private val artistDao: ArtistDao,
    private val mapArtistEntityToListModel: ArtistEntityToListModelMapper,
    private val mapArtistEntityToDetailModel: ArtistEntityToDetailModelMapper
) : ArtistRepository {

    override suspend fun getList(userId: Long): List<ArtistListItemModel> {
        val userArtistList = userArtistDao.getArtistList(userId)
            .take(1)
            .single()
        return userArtistList.artistList.map { artist ->
            val albumCount = albumDao.count(artist.id)
            val songCount = songDao.count(artist.id)
            mapArtistEntityToListModel(artist, albumCount, songCount)
        }
    }

    override suspend fun getDetail(artistId: Long): ArtistDetailModel {
        val artistEntity = artistDao.getWithLinks(artistId)
            .take(1)
            .single()
        return mapArtistEntityToDetailModel.invoke(artistEntity)
    }
}