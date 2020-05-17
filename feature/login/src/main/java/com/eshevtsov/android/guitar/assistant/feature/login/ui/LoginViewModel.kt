package com.eshevtsov.android.guitar.assistant.feature.login.ui

import androidx.lifecycle.ViewModel
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorSource
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

abstract class LoginViewModel : ViewModel(), ErrorSource {
    override val errorEvent = SingleLiveEvent<String>()
    abstract val navigateToMainEvent: SingleLiveEvent<Unit>
    abstract fun login(account: GoogleSignInAccount?)
}