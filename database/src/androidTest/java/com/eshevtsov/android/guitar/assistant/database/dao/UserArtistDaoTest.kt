package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.*
import com.eshevtsov.android.guitar.assistant.database.dto.*
import com.eshevtsov.android.guitar.assistant.database.entity.UserArtistEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith

@FlowPreview
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class UserArtistDaoTest : BaseDaoTest<UserArtistEntity>() {
    override val dao: UserArtistDao
        get() = database.userArtistDao()

    override val testData = UserArtistTestData

    override suspend fun prepopulateDatabase() {
        database.artistDao().insert(
            listOf(ArtistTestData.first(), ArtistTestData.second())
        )
        database.userDao().insert(
            listOf(UserTestData.first(), UserTestData.second())
        )
    }

    @Test
    fun get_user_artist_list_return_expected() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)
        val userArtist = UserArtistTestData.first().copy(
            id = artistId,
            userId = userId
        )
        database.userArtistDao().insert(userArtist)
        val expected = UserArtistListDto(userId, listOf(artist.copy(id = artistId)))

        val actual = database.userArtistDao().getArtistList(userId).take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_empty_user_artist_list_return_null() = runBlockingTest {
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)

        val actual = database.userArtistDao().getArtistList(userId).take(ONE).single()

        assertThat(actual).isNull()
    }

    @Test
    fun get_user_artist_with_songs_list_return_expected() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val album = AlbumTestData.withoutId().copy(artistForeignId = artistId)
        val albumId = database.albumDao().insert(album)
        val song = SongTestData.withoutId().copy(albumForeignId = albumId)
        val songId = database.songDao().insert(song)
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)
        val userArtist = UserArtistTestData.first().copy(
            id = artistId,
            userId = userId
        )
        database.userArtistDao().insert(userArtist)
        val songNameList = listOf(SongNameDto(songId, song.name))
        val albumsList = listOf(AlbumWithSongsDto(albumId, album.coverUri, songNameList))
        val expected = UserArtistWithAlbumsListDto(
            userId, listOf(ArtistWithAlbumsDto(artistId, artist.name, albumsList))
        )

        val actual = database.userArtistDao().getArtistWithAlbumsList(userId).take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun count_user_artist_return_expected() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val firstArtistId = database.artistDao().insert(artist)
        val secondArtistId = database.artistDao().insert(artist)
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)
        val userArtistList = listOf(
            UserArtistTestData.first().copy(id = firstArtistId, userId = userId),
            UserArtistTestData.first().copy(id = secondArtistId, userId = userId)
        )
        database.userArtistDao().insert(userArtistList)
        val expected = userArtistList.size

        val actual = database.userArtistDao().count(userId)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun count_empty_user_artist_return_zero() = runBlockingTest {
        val userId = UserTestData.withoutId().id
        val expected = ZERO

        val actual = database.userArtistDao().count(userId)

        assertThat(actual).isEqualTo(expected)
    }
}