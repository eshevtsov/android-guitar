package com.eshevtsov.android.guitar.assistant.koin.feature

import com.eshevtsov.android.guitar.assistant.feature.album.core.data.*
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumInteractor
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.AlbumRepository
import com.eshevtsov.android.guitar.assistant.feature.album.core.domain.DefaultAlbumInteractor
import com.eshevtsov.android.guitar.assistant.feature.album.detail.AlbumDetailFragment
import com.eshevtsov.android.guitar.assistant.feature.album.detail.AlbumDetailViewModel
import com.eshevtsov.android.guitar.assistant.feature.album.detail.DefaultAlbumDetailViewModel
import com.eshevtsov.android.guitar.assistant.feature.album.list.AlbumListFragment
import com.eshevtsov.android.guitar.assistant.feature.album.list.AlbumListViewModel
import com.eshevtsov.android.guitar.assistant.feature.album.list.DefaultAlbumListViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AlbumModule {
    val default = module {
        single<SongEntityToModelMapper> { DefaultSongEntityToModelMapper() }
        single<AlbumEntityToDetailModelMapper> { DefaultAlbumEntityToDetailModelMapper(get()) }
        single<AlbumEntityToListModelMapper> { DefaultAlbumEntityToListModelMapper() }
        single<AlbumRepository> { DefaultAlbumRepository(get(), get(), get()) }
        single<AlbumInteractor> { DefaultAlbumInteractor(get()) }
        viewModel<AlbumDetailViewModel> { DefaultAlbumDetailViewModel(get()) }
        viewModel<AlbumListViewModel> { DefaultAlbumListViewModel(get()) }
        fragment { AlbumListFragment(get(), get()) }
        fragment { AlbumDetailFragment(get(), get()) }
    }
}