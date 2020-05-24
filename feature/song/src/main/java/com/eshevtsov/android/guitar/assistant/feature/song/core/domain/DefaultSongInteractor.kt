package com.eshevtsov.android.guitar.assistant.feature.song.core.domain

import com.eshevtsov.android.guitar.assistant.feature.login.domain.Authenticator

class DefaultSongInteractor(
    private val authenticator: Authenticator,
    private val songRepository: SongRepository
) : SongInteractor{

    override suspend fun getList(): List<SongListItemModel> =
        songRepository.getAll(authenticator.user.id)
            .sortedBy(SongListItemModel::name)
}