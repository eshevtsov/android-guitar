package com.eshevtsov.android.guitar.assistant.core.feature.logger

/**
 * Platform independent utility class to more easily make logs,
 * uses [loggerImplementation] that can be passed wia [init] function to make logs.
 *
 * @author Evgeniy Shevtsov
 */
class Log {
    companion object : Logger {
        private var loggerImplementation: Logger? = null

        @JvmStatic
        override fun log(type: Logger.Type, tag: String, message: String, throwable: Throwable?) {
            loggerImplementation?.log(type, tag, message, throwable)
        }

        @JvmStatic override fun v(tag: String, message: String) = super.v(tag, message)
        @JvmStatic override fun d(tag: String, message: String) = super.d(tag, message)
        @JvmStatic override fun i(tag: String, message: String) = super.i(tag, message)
        @JvmStatic override fun w(tag: String, message: String) = super.w(tag, message)
        @JvmStatic override fun e(tag: String, message: String, throwable: Throwable?) =
            super.e(tag, message, throwable)

        @JvmStatic
        fun init(logger: Logger) {
            loggerImplementation = logger
        }
    }
}