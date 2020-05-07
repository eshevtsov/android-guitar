package com.eshevtsov.android.guitar.assistant.database.dao

import android.database.sqlite.SQLiteConstraintException
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.*
import com.eshevtsov.android.guitar.assistant.database.dto.AlbumDetailsDto
import com.eshevtsov.android.guitar.assistant.database.dto.SongNameDto
import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity
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
class AlbumDaoTest : BaseDaoTest<AlbumEntity>() {
    override val dao: AlbumDao
        get() = database.albumDao()

    override val testData = AlbumTestData

    override suspend fun prepopulateDatabase() {
        database.artistDao().insert(ArtistTestData.first())
    }

    @Test(expected = SQLiteConstraintException::class)
    fun insert_album_with_nonexistent_artist_throw_exception() = runBlockingTest {
        val nonexistentArtistId = ArtistTestData.withoutId().id
        val albumWithNonexistentArtist = AlbumTestData.first().copy(
            artistForeignId = nonexistentArtistId
        )

        database.albumDao().insert(albumWithNonexistentArtist)
    }

    @Test
    fun get_album_by_id_after_delete_artist_return_null() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val album = AlbumTestData.withoutId().copy(artistForeignId = artistId)
        val albumId = database.albumDao().insert(album)
        database.artistDao().delete(artistId)

        val actual = database.albumDao().get(albumId).take(ONE).single()

        assertThat(actual).isNull()
    }

    @Test
    fun get_all_artist_albums_return_expected() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val expected = listOf(
            AlbumTestData.first().copy(artistForeignId = artistId),
            AlbumTestData.second().copy(artistForeignId = artistId)
        )
        database.albumDao().insert(expected)

        val actual = database.albumDao().getByArtist(artistId).take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_album_details_with_songs_return_expected() = runBlockingTest {
        val artist = ArtistTestData.second()
        database.artistDao().insert(artist)
        val album = AlbumTestData.first().copy(artistForeignId = artist.id)
        database.albumDao().insert(album)
        val songs = listOf(SongTestData.first(), SongTestData.second())
        database.songDao().insert(songs)
        val expected = AlbumDetailsDto(album, artist, songs.map { SongNameDto(it.id, it.name) })

        val actual = database.albumDao().getDetails(album.id).take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_album_details_without_links_return_expected() = runBlockingTest {
        val artist = ArtistTestData.second()
        database.artistDao().insert(artist)
        val album = AlbumTestData.first().copy(artistForeignId = artist.id)
        database.albumDao().insert(album)
        val expected = AlbumDetailsDto(album, artist, emptyList())

        val actual = database.albumDao().getDetails(album.id).take(ONE).single()

        assertThat(actual).isEqualTo(expected)
    }
}