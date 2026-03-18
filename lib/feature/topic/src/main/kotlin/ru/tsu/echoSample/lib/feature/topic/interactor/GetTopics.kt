package ru.tsu.echoSample.lib.feature.topic.interactor

import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.feature.topic.model.TopicRepository
import javax.inject.Inject

class GetTopics @Inject constructor(
    private val repository: TopicRepository,
) {
    suspend fun await(): List<Topic> {
        return repository.getTopics()
    }
}
