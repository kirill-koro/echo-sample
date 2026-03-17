package ru.tsu.echoSample.lib.mapper

import ru.tsu.echoSample.lib.feature.topic.model.Source
import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.model.SourceDto
import ru.tsu.echoSample.lib.model.TopicDto

object TopicMapper {
    fun mapToSource(dto: SourceDto): Source {
        return Source(
            id = dto.id,
            title = dto.title,
            content = dto.content,
            url = dto.url,
            publishedAt = dto.publishedAt,
        )
    }

    fun mapToTopic(dto: TopicDto): Topic {
        return Topic(
            id = dto.id,
            sources = dto.sources.map(TopicMapper::mapToSource),
            title = dto.title,
            summary = dto.summary,
            content = dto.content,
            createdAt = dto.createdAt,
        )
    }
}