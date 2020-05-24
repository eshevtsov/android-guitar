package com.eshevtsov.android.guitar.assistant.koin.feature

import com.eshevtsov.android.guitar.assistant.feature.song.core.data.ArtistEntityToSongListModelMapper
import com.eshevtsov.android.guitar.assistant.feature.song.core.data.DefaultArtistEntityToSongListModelMapper
import com.eshevtsov.android.guitar.assistant.feature.song.core.data.DefaultSongRepository
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.DefaultSongInteractor
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongInteractor
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongRepository
import com.eshevtsov.android.guitar.assistant.feature.song.list.DefaultSongListViewModel
import com.eshevtsov.android.guitar.assistant.feature.song.list.SongListFragment
import com.eshevtsov.android.guitar.assistant.feature.song.list.SongListViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object SongModule {
    val default = module {
        single<ArtistEntityToSongListModelMapper> { DefaultArtistEntityToSongListModelMapper() }
        single<SongRepository> { DefaultSongRepository(get(), get()) }
        single<SongInteractor> { DefaultSongInteractor(get(), get()) }
        viewModel<SongListViewModel> { DefaultSongListViewModel(get()) }
        fragment { SongListFragment(get(), get()) }
    }
}