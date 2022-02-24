package com.example.kotlinStructure.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinStructure.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setUpNavController()
    }

    private fun setUpNavController() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(onDestinationChangedListener())
    }

    private fun onDestinationChangedListener() =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> supportActionBar?.hide()
                R.id.settingFragment -> this.supportActionBar?.hide()
                R.id.mapsFragment -> {
                    this.supportActionBar?.show()
                    this.supportActionBar?.setTitle("Map")
                }
            }
        }

    override fun onBackPressed() {
        super.onBackPressed()
        Navigation.findNavController(this, R.id.navHostFragment).popBackStack()
    }
}

