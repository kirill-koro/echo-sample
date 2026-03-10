package ru.tsu.echoSample.lib.di.module

import dagger.Binds
import dagger.Module
import ru.tsu.echoSample.lib.feature.sample.model.SampleRepository
import ru.tsu.echoSample.lib.repository.AppRepository

@Module
interface RepositoryModule {
    @Binds
    fun bindSampleRepository(implementation: AppRepository): SampleRepository
}
