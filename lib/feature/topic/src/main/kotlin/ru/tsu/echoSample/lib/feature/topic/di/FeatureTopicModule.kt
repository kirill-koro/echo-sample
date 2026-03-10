package ru.tsu.echoSample.lib.feature.topic.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.tsu.echoSample.lib.feature.topic.presentation.SearchTopicsViewModel
import ru.tsu.echoSample.lib.utils.di.viewmodel.ViewModelKey

@Module
interface FeatureTopicModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchTopicsViewModel::class)
    fun bindSampleViewModel(implementation: SearchTopicsViewModel): ViewModel
}
