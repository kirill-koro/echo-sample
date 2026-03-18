package ru.tsu.echoSample.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.tsu.echoSample.app.feature.comparator.ComparatorFragment
import ru.tsu.echoSample.app.feature.home.HomeFragment
import ru.tsu.echoSample.app.feature.profile.ProfileFragment
import ru.tsu.echoSample.app.feature.topic.BrowsedTopicsFragment
import ru.tsu.echoSample.app.feature.topic.RecommendedTopicsFragment
import ru.tsu.echoSample.app.feature.topic.SearchTopicsFragment
import ru.tsu.echoSample.app.feature.topic.TopicDetailsFragment
import ru.tsu.echoSample.lib.di.scope.FragmentScope

@Module
interface FragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    fun contributeHomeFragmentAndroidInjector(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeSearchTopicsFragmentAndroidInjector(): SearchTopicsFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeProfileFragmentAndroidInjector(): ProfileFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeBrowsedTopicsFragmentAndroidInjector(): BrowsedTopicsFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeRecommendedTopicsFragmentAndroidInjector(): RecommendedTopicsFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeTopicDetailsFragmentAndroidInjector(): TopicDetailsFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeComparatorFragmentAndroidInjector(): ComparatorFragment
}
