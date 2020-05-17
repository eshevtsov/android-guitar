package com.eshevtsov.android.guitar.assistant.core.feature.logger

/**
 * Platform independent logger abstraction.
 *
 * @author Evgeniy Shevtsov
 */
interface Logger {
    fun log(type: Type, tag: String, message: String, throwable: Throwable? = null)

    fun v(tag: String, message: String) = log(Type.VERBOSE, tag, message)
    fun d(tag: String, message: String) = log(Type.DEBUG, tag, message)
    fun i(tag: String, message: String) = log(Type.INFO, tag, message)
    fun w(tag: String, message: String) = log(Type.WARN, tag, message)
    fun e(tag: String, message: String, throwable: Throwable? = null) =
        log(Type.ERROR, tag, message, throwable)

    enum class Type {
        VERBOSE, DEBUG, INFO, WARN, ERROR
    }
}