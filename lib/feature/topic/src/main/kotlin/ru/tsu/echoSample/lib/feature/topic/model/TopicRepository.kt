package ru.tsu.echoSample.lib.feature.topic.model

interface TopicRepository {
    suspend fun getTopics(query: String): List<Topic>

    suspend fun getTopic(id: Int): Topic
}
