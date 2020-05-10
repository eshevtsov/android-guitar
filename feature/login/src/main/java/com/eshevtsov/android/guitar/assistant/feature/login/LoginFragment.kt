package com.eshevtsov.android.guitar.assistant.feature.login

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginFragment(
    private val navigation: LoginNavigation
) : Fragment(R.layout.fragment_login) {

    override fun onStart() {
        super.onStart()
        viewLifecycleOwner.lifecycleScope.launch {
            delay(1000)
            navigation.toMain()
        }
    }
}