package ru.tsu.echoSample.lib.di.module

import dagger.Binds
import dagger.Module
import ru.tsu.echoSample.lib.feature.topic.model.TopicRepository
import ru.tsu.echoSample.lib.repository.TopicRepositoryImpl

@Module
interface RepositoryModule {
    @Binds
    fun bindTopicRepository(impl: TopicRepositoryImpl): TopicRepository
}
