package com.eshevtsov.android.guitar.assistant.koin.app

import com.eshevtsov.android.guitar.assistant.MainFragment
import com.eshevtsov.android.guitar.assistant.core.feature.logger.AndroidLogger
import com.eshevtsov.android.guitar.assistant.core.feature.logger.Logger
import com.eshevtsov.android.guitar.assistant.core.feature.resource.AndroidStringProvider
import com.eshevtsov.android.guitar.assistant.core.feature.resource.StringProvider
import com.eshevtsov.android.guitar.assistant.data.AppPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

object AppModule {
    val default = module {
        single<Logger> { AndroidLogger }
        single<StringProvider> { AndroidStringProvider(androidContext().resources) }
        single { AppPreferences(androidContext()) }
        single { get<AppPreferences>().preferencesValue }
        fragment { MainFragment(get()) }
    }
}