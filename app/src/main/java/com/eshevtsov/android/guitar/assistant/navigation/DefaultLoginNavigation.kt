package com.eshevtsov.android.guitar.assistant.navigation

import android.view.View
import com.eshevtsov.android.guitar.assistant.R
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorNavigation
import com.eshevtsov.android.guitar.assistant.feature.login.ui.LoginNavigation

class DefaultLoginNavigation(
    private val appNavigator: AppNavigator
) : LoginNavigation, ErrorNavigation by appNavigator {

    override fun toMain(view: View) {
        appNavigator.navigate(view, R.id.action_login_to_main)
    }
}