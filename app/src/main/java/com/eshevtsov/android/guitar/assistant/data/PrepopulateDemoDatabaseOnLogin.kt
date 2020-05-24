package com.eshevtsov.android.guitar.assistant.data

import com.eshevtsov.android.guitar.assistant.database.GuitarAssistantDatabase
import com.eshevtsov.android.guitar.assistant.database.entity.UserArtistEntity
import com.eshevtsov.android.guitar.assistant.feature.login.domain.DemoUser
import com.eshevtsov.android.guitar.assistant.feature.login.domain.OnLogin
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserModel

class PrepopulateDemoDatabaseOnLogin(
    private val database: GuitarAssistantDatabase
) : OnLogin {

    override suspend fun invoke(user: UserModel) {
        val isNotDemoUser = user.googleTokenId != DemoUser.GOOGLE_TOKEN
        if (isNotDemoUser) {
            return
        }
        val isDemoUserDataNotEmpty = database.userArtistDao().count(user.id) != 0L
        if (isDemoUserDataNotEmpty) {
            return
        }
        prepopulateDemoUser(user)
    }

    private suspend fun prepopulateDemoUser(user: UserModel) {
        val userArtistList = DemoUserData.ARTIST_LIST
            .map { artist ->
                UserArtistEntity(user.id, artist.id)
            }
        database.run {
            artistDao().insert(DemoUserData.ARTIST_LIST)
            linkDao().insert(DemoUserData.LINK_LIST)
            albumDao().insert(DemoUserData.ALBUM_LIST)
            songDao().insert(DemoUserData.SONG_LIST)
            userArtistDao().insert(userArtistList)
        }
    }
}