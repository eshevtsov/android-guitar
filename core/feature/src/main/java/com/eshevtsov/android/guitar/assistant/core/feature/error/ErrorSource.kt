package com.eshevtsov.android.guitar.assistant.core.feature.error

import com.eshevtsov.android.guitar.assistant.core.feature.extension.TAG
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.eshevtsov.android.guitar.assistant.core.feature.logger.Log
import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * Liva data source to post error event to UI. View model can implement
 * this interface and make coroutines job with default [exceptionHandler].
 *
 * ```kotlin
 * CoroutineScope.launch(exceptionHandler) {
 *     ... some job
 * }
 * ```
 *
 * @author Evgeniy Shevtsov
 */
interface ErrorSource {
    val errorEvent: SingleLiveEvent<String>
}

/**
 * Default [ErrorSource] coroutine exception handler, catch error and
 * post message into [ErrorSource.errorEvent].
 */
val ErrorSource.exceptionHandler: CoroutineExceptionHandler
    get() = CoroutineExceptionHandler { _, throwable ->
        val message = throwable.message ?: "Some internal exception."
        Log.e(TAG, message, throwable)
        errorEvent.postValue(message)
    }