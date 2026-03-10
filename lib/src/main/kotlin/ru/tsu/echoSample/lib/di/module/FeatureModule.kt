package ru.tsu.echoSample.lib.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.tsu.echoSample.lib.di.ViewModelFactory
import ru.tsu.echoSample.lib.feature.sample.di.FeatureSampleModule

@Module(
    includes = [
        FeatureSampleModule::class,
    ]
)
interface FeatureModule {
    @Binds
    fun bindViewModelFactory(implementation: ViewModelFactory): ViewModelProvider.Factory
}
