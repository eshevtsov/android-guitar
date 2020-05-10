package com.eshevtsov.android.guitar.assistant.koin.app

import com.eshevtsov.android.guitar.assistant.MainFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

object AppModule {
    val default = module {
        fragment { MainFragment(get()) }
    }
}