package com.eshevtsov.android.guitar.assistant.core.feature.error

import android.view.View

/**
 * Simple abstraction to encapsulate showing error logic.
 *
 * @author Evgeniy Shevtsov
 */
interface ErrorNavigation {
    fun showError(view: View, message: String)
}