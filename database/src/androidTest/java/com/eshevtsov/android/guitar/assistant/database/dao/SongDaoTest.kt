package com.eshevtsov.android.guitar.assistant.database.dao

import android.database.sqlite.SQLiteConstraintException
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eshevtsov.android.guitar.assistant.database.data.*
import com.eshevtsov.android.guitar.assistant.database.dto.*
import com.eshevtsov.android.guitar.assistant.database.entity.SongEntity
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
class SongDaoTest : BaseDaoTest<SongEntity>() {
    override val dao: SongDao
        get() = database.songDao()

    override val testData = SongTestData

    override suspend fun prepopulateDatabase() {
        database.artistDao().insert(ArtistTestData.first())
        database.albumDao().insert(AlbumTestData.first())
    }

    @Test
    fun get_song_details_by_id_return_expected() = runBlockingTest {
        val artist = ArtistTestData.second()
        database.artistDao().insert(artist)
        val album = AlbumTestData.second().copy(artistForeignId = artist.id)
        database.albumDao().insert(album)
        val song = SongTestData.second().copy(albumForeignId = album.id)
        database.songDao().insert(song)
        val expected = SongDetailsDto(song, AlbumWithArtistDto(album, artist))

        val actual = database.songDao().getDetails(song.id).take(ONE).single()

        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun get_song_simple_by_id_return_expected() = runBlockingTest {
        val artist = ArtistTestData.second()
        database.artistDao().insert(artist)
        val album = AlbumTestData.second().copy(artistForeignId = artist.id)
        database.albumDao().insert(album)
        val song = SongTestData.second().copy(albumForeignId = album.id)
        database.songDao().insert(song)
        val expected = SongSimpleDto(
            song.id, song.name, album.id,
            AlbumSimpleDto(
                album.coverUri, artist.id, ArtistNameDto(artist.name)
            )
        )

        val actual = database.songDao().getSimple(song.id).take(ONE).single()

        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test(expected = SQLiteConstraintException::class)
    fun insert_song_with_nonexistent_album_throw_exception() = runBlockingTest {
        val nonexistentAlbumId = AlbumTestData.withoutId().id
        val songWithNonexistentArtist = SongTestData.first().copy(
            albumForeignId = nonexistentAlbumId
        )

        database.songDao().insert(songWithNonexistentArtist)
    }

    @Test
    fun get_song_by_id_after_delete_album_return_null() = runBlockingTest {
        val album = AlbumTestData.withoutId()
        val albumId = database.albumDao().insert(album)
        val song = SongTestData.withoutId().copy(albumForeignId = albumId)
        val songId = database.songDao().insert(song)
        database.albumDao().delete(albumId)

        val actual = database.songDao().get(songId).take(ONE).single()

        Truth.assertThat(actual).isNull()
    }

    @Test
    fun count_artist_songs_return_expected() = runBlockingTest {
        val artist = ArtistTestData.withoutId()
        val artistId = database.artistDao().insert(artist)
        val album = AlbumTestData.withoutId().copy(artistForeignId = artistId)
        val firstAlbumId = database.albumDao().insert(album)
        val secondAlbumId = database.albumDao().insert(album)
        val anotherAuthorSong = SongTestData.first()
        database.songDao().insert(anotherAuthorSong)
        val songs = listOf(
            SongTestData.withoutId().copy(albumForeignId = firstAlbumId),
            SongTestData.withoutId().copy(albumForeignId = firstAlbumId),
            SongTestData.withoutId().copy(albumForeignId = secondAlbumId),
            SongTestData.withoutId().copy(albumForeignId = secondAlbumId),
            SongTestData.withoutId().copy(albumForeignId = secondAlbumId)
        )
        database.songDao().insert(songs)
        val expected = songs.size

        val actual = database.songDao().count(artistId)

        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun count_empty_artist_songs_return_zero() = runBlockingTest {
        val artistId = ArtistTestData.withoutId().id
        val expected = ZERO

        val actual = database.songDao().count(artistId)

        Truth.assertThat(actual).isEqualTo(expected)
    }
}