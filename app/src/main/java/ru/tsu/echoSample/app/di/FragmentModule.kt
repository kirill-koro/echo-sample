package ru.tsu.echoSample.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.tsu.echoSample.app.feature.sample.AssistedSampleFragment
import ru.tsu.echoSample.app.feature.sample.SampleFragment
import ru.tsu.echoSample.lib.di.scope.FragmentScope

@Module
interface FragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    fun contributeSampleFragmentAndroidInjector(): SampleFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeAssistedSampleFragmentAndroidInjector(): AssistedSampleFragment
}
