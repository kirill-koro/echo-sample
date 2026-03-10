package ru.tsu.echoSample.lib.feature.sample.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.tsu.echoSample.lib.feature.sample.presentation.SampleViewModel
import ru.tsu.echoSample.lib.utils.di.viewmodel.ViewModelKey

@Module
interface FeatureSampleModule {
    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    fun bindSampleViewModel(implementation: SampleViewModel): ViewModel
}
