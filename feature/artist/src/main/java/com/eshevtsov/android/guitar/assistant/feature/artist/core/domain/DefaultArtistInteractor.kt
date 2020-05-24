package com.eshevtsov.android.guitar.assistant.feature.artist.core.domain

import com.eshevtsov.android.guitar.assistant.feature.login.domain.Authenticator

class DefaultArtistInteractor(
    private val authenticator: Authenticator,
    private val artistRepository: ArtistRepository
) : ArtistInteractor {

    override suspend fun getList(): List<ArtistListItemModel> =
        artistRepository.getList(authenticator.user.id)
}