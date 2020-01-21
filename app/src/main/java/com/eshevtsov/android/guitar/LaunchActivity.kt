package com.eshevtsov.android.guitar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eshevtsov.android.guitar.presentation.launch.LaunchFragment

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LaunchFragment.newInstance())
                .commitNow()
        }
    }

}
