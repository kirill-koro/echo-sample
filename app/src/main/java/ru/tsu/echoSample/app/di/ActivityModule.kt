package ru.tsu.echoSample.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.tsu.echoSample.app.MainActivity
import ru.tsu.echoSample.lib.di.scope.MainScope

@Module
interface ActivityModule {
    @MainScope
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    fun contributeMainActivityAndroidInjector(): MainActivity
}
