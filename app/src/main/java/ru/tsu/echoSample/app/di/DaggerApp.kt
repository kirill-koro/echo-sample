package ru.tsu.echoSample.app.di

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.tsu.echoSample.app.BuildConfig
import javax.inject.Inject

open class DaggerApp : Application(), HasAndroidInjector {
    @Inject
    lateinit var appInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<in Any> = appInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .baseUrl(BuildConfig.BASE_URL)
            .appContext(applicationContext)
            .build()
            .inject(this)
    }
}
