package com.eshevtsov.android.guitar.assistant.navigation

import com.eshevtsov.android.guitar.assistant.R
import com.eshevtsov.android.guitar.assistant.feature.login.LoginNavigation

class DefaultLoginNavigation(
    private val appNavigator: AppNavigator
) : LoginNavigation {

    override fun toMain() {
        appNavigator.navigate(R.id.action_login_to_main)
    }
}