package com.eshevtsov.android.guitar.assistant.core.feature.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorSource

/**
 * Extension function that allow to observe error in more easy way.
 *
 * @author Evgeniy Shevtsov
 */
fun Fragment.defaultErrorObserve(errorSource: ErrorSource, errorNavigation: ErrorNavigation) {
    errorSource.errorEvent.observe(viewLifecycleOwner, Observer {
        errorNavigation.showError(requireView(), it)
    })
}

/**
 * Extension function that allow to observe [LiveData] in more easy way.
 *
 * ```kotlin
 * observe(liveData) { result ->
 *     ... on changed action
 * }
 * ```
 *
 * @author Evgeniy Shevtsov
 */
inline fun <reified T> Fragment.observe(liveData: LiveData<T>, noinline observer: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer(observer::invoke))
}