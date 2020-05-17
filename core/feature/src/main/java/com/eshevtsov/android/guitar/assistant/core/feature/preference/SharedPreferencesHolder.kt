package com.eshevtsov.android.guitar.assistant.core.feature.preference

import android.content.SharedPreferences
import com.eshevtsov.android.guitar.assistant.core.feature.preference.SharedPreferencesHolder.Default

/**
 * Holder for android [SharedPreferences] instance with list of [Default] values .
 *
 * @author Evgeniy Shevtsov
 */
interface SharedPreferencesHolder {
    val preferences: SharedPreferences

    object Default {
        const val LONG: Long = 0L
        const val FLOAT: Float = 0f
        const val INT: Int = 0
        const val STRING: String = ""
        const val BOOLEAN: Boolean = false
    }
}