package com.eshevtsov.android.guitar.assistant.navigation

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation

interface AppNavigator : ErrorNavigation {
    fun navigate(view: View, @IdRes destinationId: Int, arguments: Bundle? = null)
}