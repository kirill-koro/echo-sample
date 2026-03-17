package ru.tsu.echoSample.lib.feature.topic.model

interface TopicRepository {
    suspend fun getTopics(): List<Topic>

    suspend fun getTopic(id: Int): Topic
}
