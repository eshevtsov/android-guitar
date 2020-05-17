package com.eshevtsov.android.guitar.assistant.core.feature

import com.eshevtsov.android.guitar.assistant.core.feature.extension.TAG
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ClassExtTest {

    @Test
    fun get_class_name_using_extension_return_expected() {
        val expected = this::class.java.name

        val actual = this.TAG

        assertThat(actual).isEqualTo(expected)
    }
}