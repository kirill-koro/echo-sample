package ru.tsu.echoSample.app.feature.home

import android.os.Bundle
import android.view.View
import androidx.navigation.ui.setupWithNavController
import ru.tsu.echoSample.app.R
import ru.tsu.echoSample.app.databinding.HomeFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment
import ru.tsu.echoSample.app.utils.requireHomeNavHostFragment

class HomeFragment : NoParamsFragment<HomeFragmentBinding>() {
    override val bind = HomeFragmentBinding::bind
    override val layoutRes = R.layout.home_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupComponents()
    }

    private fun setupComponents() {
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navHostFragment = requireHomeNavHostFragment()
        content.bottomNav.setupWithNavController(navHostFragment.navController)
    }
}
