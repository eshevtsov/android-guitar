package com.eshevtsov.android.guitar.assistant.koin.feature

import com.eshevtsov.android.guitar.assistant.feature.home.HomeFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

object HomeModule {
    val default = module {
        fragment { HomeFragment(get(), get()) }
    }
}