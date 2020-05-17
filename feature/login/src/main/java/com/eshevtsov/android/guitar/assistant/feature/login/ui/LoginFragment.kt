package com.eshevtsov.android.guitar.assistant.feature.login.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.eshevtsov.android.guitar.assistant.core.feature.extension.defaultErrorObserve
import com.eshevtsov.android.guitar.assistant.core.feature.extension.observe
import com.eshevtsov.android.guitar.assistant.feature.login.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment(
    signInContract: GoogleSignInExt.Contract,
    private val navigation: LoginNavigation,
    private val viewModel: LoginViewModel
) : Fragment(R.layout.fragment_login) {

    private val login = registerForActivityResult(signInContract, viewModel::login)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        login_button.setOnClickListener {
            login.launch(Unit)
        }
    }

    private fun observeViewModel() = viewModel.run {
        defaultErrorObserve(this, navigation)
        observe(navigateToMainEvent) {
            navigation.toMain(requireView())
        }
    }
}