package com.eshevtsov.android.guitar.assistant.database.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.*
import com.eshevtsov.android.guitar.assistant.database.dto.*
import com.eshevtsov.android.guitar.assistant.database.entity.FavouriteSongEntity
import com.google.common.truth.Truth
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
class FavouriteSongDaoTest : BaseDaoTest<FavouriteSongEntity>() {
    override val dao: FavouriteSongDao
        get() = database.favouriteSongDao()

    override val testData = FavouriteSongTestData

    override suspend fun prepopulateDatabase() {
        database.artistDao().insert(ArtistTestData.first())
        database.albumDao().insert(
            listOf(AlbumTestData.first(), AlbumTestData.second())
        )
        database.songDao().insert(
            listOf(SongTestData.first(), SongTestData.second())
        )
        database.userDao().insert(
            listOf(UserTestData.first(), UserTestData.second())
        )
    }

    @Test
    fun get_favourite_song_list_return_expected() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val album = AlbumTestData.withoutId().copy(artistForeignId = artistId)
        val albumId = database.albumDao().insert(album)
        val song = SongTestData.withoutId().copy(albumForeignId = albumId)
        val songId = database.songDao().insert(song)
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)
        val favouriteSong = FavouriteSongTestData.first().copy(
            id = songId,
            userId = userId
        )
        database.favouriteSongDao().insert(favouriteSong)
        val simpleSong = SongSimpleDto(
            songId, song.name, albumId,
            AlbumSimpleDto(
                album.coverUri, artistId, ArtistNameDto(artist.name)
            )
        )
        val expected = FavouriteSongListDto(userId, listOf(simpleSong))

        val actual = database.favouriteSongDao().getSongList(userId).take(ONE).single()

        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_empty_favourite_song_list_return_null() = runBlockingTest {
        val user = UserTestData.withoutId()
        val userId = database.userDao().insert(user)

        val actual = database.favouriteSongDao().getSongList(userId).take(ONE).single()

        Truth.assertThat(actual).isNull()
    }
}