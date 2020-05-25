package com.eshevtsov.android.guitar.assistant.koin.feature

import com.eshevtsov.android.guitar.assistant.feature.song.core.data.*
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.DefaultSongInteractor
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongInteractor
import com.eshevtsov.android.guitar.assistant.feature.song.core.domain.SongRepository
import com.eshevtsov.android.guitar.assistant.feature.song.detail.DefaultSongDetailViewModel
import com.eshevtsov.android.guitar.assistant.feature.song.detail.SongDetailFragment
import com.eshevtsov.android.guitar.assistant.feature.song.detail.SongDetailViewModel
import com.eshevtsov.android.guitar.assistant.feature.song.list.DefaultSongListViewModel
import com.eshevtsov.android.guitar.assistant.feature.song.list.SongListFragment
import com.eshevtsov.android.guitar.assistant.feature.song.list.SongListViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object SongModule {
    val default = module {
        single<SongDetailsEntityToModelMapper> { DefaultSongDetailsEntityToModelMapper() }
        single<ArtistEntityToSongListModelMapper> { DefaultArtistEntityToSongListModelMapper() }
        single<SongRepository> { DefaultSongRepository(get(), get(), get(), get()) }
        single<SongInteractor> { DefaultSongInteractor(get(), get()) }
        viewModel<SongListViewModel> { DefaultSongListViewModel(get()) }
        viewModel<SongDetailViewModel> { DefaultSongDetailViewModel(get()) }
        fragment { SongDetailFragment(get(), get()) }
        fragment { SongListFragment(get(), get()) }
    }
}