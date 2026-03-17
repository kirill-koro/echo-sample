package ru.tsu.echoSample.app.utils

import androidx.navigation.fragment.NavHostFragment
import ru.tsu.echoSample.app.R
import ru.tsu.echoSample.app.di.DaggerActivity
import ru.tsu.echoSample.app.di.DaggerFragment

internal fun DaggerActivity.requireMainNavHostFragment(): NavHostFragment {
    val host =
        supportFragmentManager.findFragmentById(R.id.mainNavHostFragment) as? NavHostFragment
    requireNotNull(host) { "The main nav host fragment was not found" }
    return host
}

internal fun DaggerFragment<*>.requireMainNavHostFragment(): NavHostFragment {
    val host = (requireActivity() as? DaggerActivity)?.requireMainNavHostFragment()
    requireNotNull(host) { "The main nav host fragment was not found" }
    return host
}

internal fun DaggerFragment<*>.requireHomeNavHostFragment(): NavHostFragment {
    val host =
        childFragmentManager.findFragmentById(R.id.homeNavHostFragment) as? NavHostFragment
    requireNotNull(host) { "The home nav host fragment was not found" }
    return host
}
