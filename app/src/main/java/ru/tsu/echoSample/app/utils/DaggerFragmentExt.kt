package ru.tsu.echoSample.app.utils

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import ru.tsu.echoSample.app.di.DaggerFragment

internal val DaggerFragment<*>.toolbar: ActionBar
    get() {
        val toolbar = (this.requireActivity() as? AppCompatActivity)?.supportActionBar
        requireNotNull(toolbar) { "The toolbar inside ${this::class.simpleName} wasn't found" }
        return toolbar
    }
