package com.eshevtsov.android.guitar.assistant.feature.album.core.domain

class DefaultAlbumInteractor(
    private val albumRepository: AlbumRepository
) : AlbumInteractor {

    override suspend fun getAll(artistId: Long): List<AlbumListItemModel> =
        albumRepository.getAll(artistId)

    override suspend fun getDetails(albumId: Long): AlbumDetailModel =
        albumRepository.getDetails(albumId)
}