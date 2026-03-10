package ru.tsu.echoSample.app

import io.github.aakira.napier.Napier
import ru.tsu.echoSample.app.di.DaggerApp
import ru.tsu.echoSample.lib.di.configureExceptionMappers
import ru.tsu.echoSample.utils.LogcatAntilog

class App : DaggerApp() {
    override fun onCreate() {
        super.onCreate()
        val antilog: LogcatAntilog? = if (BuildConfig.DEBUG) {
            LogcatAntilog()
        } else {
            null
        }

        antilog?.let { Napier.base(antilog = it) }
        configureExceptionMappers()
    }
}
