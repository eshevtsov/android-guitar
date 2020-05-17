package com.eshevtsov.android.guitar.assistant.feature.login.ui

import android.view.View
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation

interface LoginNavigation : ErrorNavigation {
    fun toMain(view: View)
}