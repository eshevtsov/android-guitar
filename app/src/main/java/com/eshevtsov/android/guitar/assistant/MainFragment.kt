package com.eshevtsov.android.guitar.assistant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment
import com.eshevtsov.android.guitar.assistant.extensions.initWith

class MainFragment(
    private val fragmentFactory: FragmentFactory
) : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavHostFragment()
    }

    private fun initNavHostFragment() {
        val navHost = childFragmentManager
            .findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navHost.initWith(R.navigation.main_nav_graph, R.id.home, fragmentFactory)
    }
}