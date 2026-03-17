package ru.tsu.echoSample.lib.repository

import ru.tsu.echoSample.lib.api.EchoApi
import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.feature.topic.model.TopicRepository
import ru.tsu.echoSample.lib.mapper.TopicMapper
import javax.inject.Inject

class TopicRepositoryImpl @Inject constructor(
    private val echoApi: EchoApi,
) : TopicRepository {
    override suspend fun getTopics(): List<Topic> {
        return echoApi.getTopics().map(TopicMapper::mapToTopic)
    }

    override suspend fun getTopic(id: Int): Topic {
        return TopicMapper.mapToTopic(dto = echoApi.getTopic(id))
    }
}
