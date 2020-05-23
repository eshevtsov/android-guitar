package com.eshevtsov.android.guitar.assistant.feature.login.domain

class DefaultUserInteractor(
    private val authenticator: Authenticator,
    private val userRepository: UserRepository,
    private val userPreferences: LoggedUserPreferences,
    private val onLoginSet: Set<OnLogin>,
    private val onLogoutSet: Set<OnLogout>
) : UserInteractor {

    override suspend fun loginWithGoogle(
        googleTokenId: String,
        displayTitle: String?
    ) {
        val user = userRepository.get(googleTokenId)
            ?: userRepository.create(googleTokenId, displayTitle)
        onLogin(user)
    }

    override suspend fun demo() {
        loginWithGoogle(DemoUser.GOOGLE_TOKEN, DemoUser.DISPLAY_NAME)
    }

    override suspend fun trySilentLogin(): Boolean {
        val userId = userPreferences.loggedUserId
        val user = userRepository.get(userId)
        if (user != null) {
            onLogin(user)
        }
        return user != null
    }

    override suspend fun logout() {
        authenticator.release()
        onLogout()
    }

    private suspend fun onLogin(user: UserModel) {
        authenticator.init(user)
        userPreferences.loggedUserId = user.id
        onLoginSet.forEach { onLogin -> onLogin.invoke(user) }
    }

    private suspend fun onLogout() {
        onLogoutSet.forEach { onLogout -> onLogout.invoke() }
    }
}