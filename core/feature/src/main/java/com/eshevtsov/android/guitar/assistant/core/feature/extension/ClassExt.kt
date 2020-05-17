package com.eshevtsov.android.guitar.assistant.core.feature.extension

/**
 * Extension property that allow to get class name in more easy way.
 *
 * @author Evgeniy Shevtsov
 */
inline val <reified T : Any> T.TAG: String
    get() = this::class.java.name