package com.eshevtsov.android.guitar.assistant.core.feature.preference

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * Kotlin property delegate that allow to encapsulate logic of working with
 * android [SharedPreferences] and allow to avoid code boilerplate.
 *
 * ```kotlin
 * class HolderImplementation(
 *     override val preferences: SharedPreferences
 * ) : SharedPreferencesHolder {
 *     var booleanFlag: Boolean by preference("prefName")
 * }
 * ```
 *
 * _Note_: Support only types of [SharedPreferences] except Set<String>.
 *
 * @throws IllegalPreferenceTypeException
 * @author Evgeniy Shevtsov
 */
class Preference<T : Any>(
    private val key: String,
    private val type: KClass<T>
) : ReadWriteProperty<SharedPreferencesHolder, T> {

    @Suppress("UNCHECKED_CAST")
    override fun getValue(
        thisRef: SharedPreferencesHolder,
        property: KProperty<*>
    ): T = thisRef.preferences.run {
        when (type) {
            Boolean::class -> getBoolean(key, SharedPreferencesHolder.Default.BOOLEAN)
            Int::class -> getInt(key, SharedPreferencesHolder.Default.INT)
            Float::class -> getFloat(key, SharedPreferencesHolder.Default.FLOAT)
            Long::class -> getLong(key, SharedPreferencesHolder.Default.LONG)
            String::class -> getString(key, SharedPreferencesHolder.Default.STRING)
            else -> throw IllegalPreferenceTypeException(type)
        }
    } as T

    override fun setValue(
        thisRef: SharedPreferencesHolder,
        property: KProperty<*>,
        value: T
    ) = thisRef.preferences.edit {
        when (value) {
            is Boolean -> putBoolean(key, value)
            is Int -> putInt(key, value)
            is Float -> putFloat(key, value)
            is Long -> putLong(key, value)
            is String -> putString(key, value)
            else -> throw IllegalPreferenceTypeException(type)
        }
    }
}

inline fun <reified T : Any> preference(key: String): Preference<T> = Preference(key, T::class)

class IllegalPreferenceTypeException(type: Any)
    : IllegalStateException("Preference type for: $type, - not found")