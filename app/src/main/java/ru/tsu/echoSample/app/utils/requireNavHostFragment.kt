package ru.tsu.echoSample.app.utils

import androidx.navigation.fragment.NavHostFragment
import ru.tsu.echoSample.app.R
import ru.tsu.echoSample.app.di.DaggerActivity

internal fun DaggerActivity.requireNavHostFragment(): NavHostFragment {
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.navHostFragment) as? NavHostFragment
    requireNotNull(navHostFragment) { "The nav host fragment was not found" }
    return navHostFragment
}
