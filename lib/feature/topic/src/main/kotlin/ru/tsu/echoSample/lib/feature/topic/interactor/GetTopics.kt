package ru.tsu.echoSample.lib.feature.topic.interactor

import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.feature.topic.model.TopicRepository
import javax.inject.Inject

class GetTopics @Inject constructor(
    private val repository: TopicRepository,
) {
    suspend fun await(query: String): List<Topic> {
        return repository.getTopics(query)
    }
}
