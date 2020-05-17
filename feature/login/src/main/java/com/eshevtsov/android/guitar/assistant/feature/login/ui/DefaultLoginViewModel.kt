package com.eshevtsov.android.guitar.assistant.feature.login.ui

import androidx.lifecycle.viewModelScope
import com.eshevtsov.android.guitar.assistant.core.feature.error.exceptionHandler
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import com.eshevtsov.android.guitar.assistant.feature.login.domain.NoLoggedUserException
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserInteractor
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.coroutines.launch

class DefaultLoginViewModel(
    private val userInteractor: UserInteractor
) : LoginViewModel() {

    override val navigateToMainEvent = SingleLiveEvent<Unit>()

    override fun login(account: GoogleSignInAccount?) {
        viewModelScope.launch(exceptionHandler) {
            val id = account?.id ?: throw NoLoggedUserException()
            userInteractor.loginWithGoogle(id, account.email)
            navigateToMainEvent.call()
        }
    }
}