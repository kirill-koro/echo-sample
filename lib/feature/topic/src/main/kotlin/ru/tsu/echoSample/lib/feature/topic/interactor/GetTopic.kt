package ru.tsu.echoSample.lib.feature.topic.interactor

import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.feature.topic.model.TopicRepository
import javax.inject.Inject

class GetTopic @Inject constructor(
    private val repository: TopicRepository,
) {
    suspend fun await(id: Int): Topic {
        return repository.getTopic(id)
    }
}
