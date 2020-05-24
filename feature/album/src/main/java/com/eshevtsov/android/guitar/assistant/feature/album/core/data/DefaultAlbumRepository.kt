package com.eshevtsov.android.guitar.assistant.feature.album.core.data

import com.eshevtsov.android.guitar.assistant.database.dao.AlbumDao
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumListItemModel
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumRepository
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.take

class DefaultAlbumRepository(
    private val albumDao: AlbumDao,
    private val mapAlbumEntityToListModel: AlbumEntityToListModelMapper
) : AlbumRepository {

    override suspend fun getAll(artistId: Long): List<AlbumListItemModel> {
        val albumList = albumDao.getByArtist(artistId)
            .take(1)
            .single()
        return albumList.map(mapAlbumEntityToListModel::invoke)
    }
}