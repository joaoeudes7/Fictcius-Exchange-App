package com.klever.price.ui

import android.os.Bundle
import androidx.navigation.findNavController
import com.jdeve.mesanews.base.BaseActivity
import com.klever.price.R
import com.klever.price.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            title = destination.label
        }
    }

    override fun onViewCreated() {

    }
}