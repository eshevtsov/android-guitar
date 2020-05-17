package com.eshevtsov.android.guitar.assistant.core.feature

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.eshevtsov.android.guitar.assistant.core.feature.data.PreferenceTestData
import com.eshevtsov.android.guitar.assistant.core.feature.preference.IllegalPreferenceTypeException
import com.eshevtsov.android.guitar.assistant.core.feature.preference.SharedPreferencesHolder
import com.eshevtsov.android.guitar.assistant.core.feature.preference.preference
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PreferenceTest {
    private val sharedPreferences = getInstrumentation().targetContext
        .getSharedPreferences(PreferenceTestData.preferenceName, Context.MODE_PRIVATE)

    @Test(expected = IllegalPreferenceTypeException::class)
    fun using_unsupported_type_throw_exception() {
        val holder = object : SharedPreferencesHolder {
            override val preferences = sharedPreferences
            var pref: Unit by preference(PreferenceTestData.firstKey)
        }

        holder.pref = Unit
    }

    @Test(expected = Test.None::class)
    fun set_boolean_no_exception() =
        set_type_no_exception(PreferenceTestData.firstBoolean)
    @Test
    fun get_existing_boolean_returns_expected() =
        get_existing_type_returns_expected(PreferenceTestData.firstBoolean)
    @Test
    fun get_nonexistent_boolean_returns_default() =
        get_existing_type_returns_expected(SharedPreferencesHolder.Default.BOOLEAN)

    @Test(expected = Test.None::class)
    fun set_long_no_exception() =
        set_type_no_exception(PreferenceTestData.firstLong)
    @Test
    fun get_existing_long_returns_expected() =
        get_existing_type_returns_expected(PreferenceTestData.firstLong)
    @Test
    fun get_nonexistent_long_returns_default() =
        get_existing_type_returns_expected(SharedPreferencesHolder.Default.LONG)

    @Test(expected = Test.None::class)
    fun set_int_no_exception() =
        set_type_no_exception(PreferenceTestData.firstInt)
    @Test
    fun get_existing_int_returns_expected() =
        get_existing_type_returns_expected(PreferenceTestData.firstInt)
    @Test
    fun get_nonexistent_int_returns_default() =
        get_existing_type_returns_expected(SharedPreferencesHolder.Default.INT)

    @Test(expected = Test.None::class)
    fun set_float_no_exception() =
        set_type_no_exception(PreferenceTestData.firstFloat)
    @Test
    fun get_existing_float_returns_expected() =
        get_existing_type_returns_expected(PreferenceTestData.firstFloat)
    @Test
    fun get_nonexistent_float_returns_default() =
        get_existing_type_returns_expected(SharedPreferencesHolder.Default.FLOAT)

    @Test(expected = Test.None::class)
    fun set_string_no_exception() =
        set_type_no_exception(PreferenceTestData.firstString)
    @Test
    fun get_existing_string_returns_expected() =
        get_existing_type_returns_expected(PreferenceTestData.firstString)
    @Test
    fun get_nonexistent_string_returns_default() =
        get_existing_type_returns_expected(SharedPreferencesHolder.Default.STRING)

    private inline fun <reified T : Any> set_type_no_exception(value: T) {
        val holder = object : SharedPreferencesHolder {
            override val preferences = sharedPreferences
            var pref: T by preference(PreferenceTestData.firstKey)
        }

        holder.pref = value
    }

    private inline fun <reified T : Any> get_existing_type_returns_expected(expected: T) {
        val holder = object : SharedPreferencesHolder {
            override val preferences = sharedPreferences
            var pref: T by preference(PreferenceTestData.firstKey)
        }
        holder.pref = expected

        val actual = holder.pref

        assertThat(actual).isEqualTo(expected)
    }

    private inline fun <reified T : Any> get_nonexistent_type_returns_default(expected: T) {
        val holder = object : SharedPreferencesHolder {
            override val preferences = sharedPreferences
            var pref: T by preference(PreferenceTestData.firstKey)
        }

        val actual = holder.pref

        assertThat(actual).isEqualTo(expected)
    }
}