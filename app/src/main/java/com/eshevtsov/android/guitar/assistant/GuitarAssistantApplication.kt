package com.eshevtsov.android.guitar.assistant

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.eshevtsov.android.guitar.assistant.core.feature.logger.Log
import com.eshevtsov.android.guitar.assistant.koin.KoinModules
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

class GuitarAssistantApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GuitarAssistantApplication)
            fragmentFactory()
            modules(KoinModules.list)
        }

        Log.init(get())

        // TODO: Get from user settings shared preferences
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}