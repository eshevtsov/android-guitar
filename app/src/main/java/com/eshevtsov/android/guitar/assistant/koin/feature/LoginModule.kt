package com.eshevtsov.android.guitar.assistant.koin.feature

import com.eshevtsov.android.guitar.assistant.feature.login.LoginFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

object LoginModule {
    val default = module {
        fragment { LoginFragment(get()) }
    }
}