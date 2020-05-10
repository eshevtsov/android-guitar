package com.eshevtsov.android.guitar.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment
import com.eshevtsov.android.guitar.assistant.extensions.initWith
import com.eshevtsov.android.guitar.assistant.navigation.AppNavigator
import org.koin.android.ext.android.inject

class LaunchActivity : AppCompatActivity(R.layout.activity_launch) {

    private val appNavigation: AppNavigator by inject()
    private val fragmentFactory: FragmentFactory by inject()

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

    override fun onDestroy() {
        appNavigation.unbind()
        super.onDestroy()
    }

    private fun initNavHostFragment() {
        navHost?.run {
            initWith(R.navigation.launch_nav_graph, R.id.login, fragmentFactory)
            appNavigation.bind(navController)
        }
    }
}