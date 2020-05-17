package com.eshevtsov.android.guitar.assistant.feature.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.eshevtsov.android.guitar.assistant.feature.login.domain.Authenticator
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserInteractor
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class HomeFragment(
    private val authenticator: Authenticator,
    private val userInteractor: UserInteractor
) : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dark_theme_switch.setOnCheckedChangeListener { _, isChecked ->
            val nightMode = when {
                isChecked -> AppCompatDelegate.MODE_NIGHT_YES
                else -> AppCompatDelegate.MODE_NIGHT_NO
            }
            AppCompatDelegate.setDefaultNightMode(nightMode)
        }
        user_title_text_view.text = authenticator.user.displayTitle
        logout_text_view.setOnClickListener {
            lifecycleScope.launch {
                userInteractor.logout()
                requireActivity().finish()
            }
        }
    }
}