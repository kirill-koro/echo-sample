package ru.tsu.echoSample.lib.api

import kotlinx.coroutines.delay
import ru.tsu.echoSample.lib.model.TopicDto
import kotlin.time.Duration.Companion.milliseconds

class EchoApi {
    suspend fun getTopics(): List<TopicDto> {
        delay(300.milliseconds)
        return List((0..10).random(), TopicDto::create)
    }

    suspend fun getTopic(id: Int): TopicDto {
        delay(300.milliseconds)
        return TopicDto.create(id)
    }
}
