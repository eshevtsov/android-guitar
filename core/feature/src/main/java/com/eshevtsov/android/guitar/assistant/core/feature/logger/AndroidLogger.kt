package com.eshevtsov.android.guitar.assistant.core.feature.logger

import android.util.Log

object AndroidLogger : Logger {
    override fun log(type: Logger.Type, tag: String, message: String, throwable: Throwable?) {
        when (type) {
            Logger.Type.VERBOSE -> Log.v(tag, message)
            Logger.Type.DEBUG -> Log.d(tag, message)
            Logger.Type.INFO -> Log.i(tag, message)
            Logger.Type.WARN -> Log.w(tag, message)
            Logger.Type.ERROR -> Log.e(tag, message, throwable)
        }
    }
}