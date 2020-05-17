package com.eshevtsov.android.guitar.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.eshevtsov.android.guitar.assistant.extensions.initWith
import com.eshevtsov.android.guitar.assistant.feature.login.domain.UserInteractor
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class LaunchActivity : AppCompatActivity(R.layout.activity_launch) {

    private val fragmentFactory: FragmentFactory by inject()
    private val userInteractor: UserInteractor by inject()

    private val navHost: NavHostFragment?
        get() = supportFragmentManager.findFragmentById(R.id.launch_nav_host_fragment) as? NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        supportFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            initNavHostFragment()
        }
    }

    private fun initNavHostFragment() {
        lifecycleScope.launch {
            val startDestId = when {
                userInteractor.trySilentLogin() -> R.id.main
                else -> R.id.login
            }
            navHost?.initWith(R.navigation.launch_nav_graph, startDestId, fragmentFactory)
        }
    }
}