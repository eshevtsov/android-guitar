package com.eshevtsov.android.guitar.assistant.feature.login.domain

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

class GoogleSignOutOnLogout(
    private val googleSignInClient: GoogleSignInClient
) : OnLogout {
    override suspend fun invoke() = suspendCancellableCoroutine<Unit> { continuation ->
        googleSignInClient.signOut()
            .addOnCanceledListener {
                continuation.cancel()
            }
            .addOnSuccessListener {
                continuation.resumeWith(Result.success(Unit))
            }
            .addOnFailureListener { exception ->
                continuation.resumeWithException(exception)
            }
    }
}