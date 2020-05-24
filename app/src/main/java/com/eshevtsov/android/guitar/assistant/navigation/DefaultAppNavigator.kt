package com.eshevtsov.android.guitar.assistant.navigation

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar

class DefaultAppNavigator : AppNavigator {

    override fun navigate(view: View, destinationId: Int, arguments: Bundle?) {
        view.findNavController().navigate(destinationId, arguments)
    }

    override fun showError(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            .show()
    }
}