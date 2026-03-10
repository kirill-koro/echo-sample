package ru.tsu.echoSample.app.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ui.setupWithNavController
import ru.tsu.echoSample.app.databinding.HomeFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment
import ru.tsu.echoSample.app.utils.requireHomeNavHostFragment

class HomeFragment : NoParamsFragment<HomeFragmentBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> HomeFragmentBinding
        get() = HomeFragmentBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navHostFragment = requireHomeNavHostFragment()
        binding.bottomNav.setupWithNavController(navHostFragment.navController)
    }
}
