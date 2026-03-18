package ru.tsu.echoSample.app.feature.topic.mapper

import ru.tsu.echoSample.app.feature.topic.model.SourceUi
import ru.tsu.echoSample.app.feature.topic.model.TopicUi
import ru.tsu.echoSample.lib.feature.topic.model.Source
import ru.tsu.echoSample.lib.feature.topic.model.Topic

object TopicMapper {
    fun mapToSourceUi(source: Source): SourceUi {
        return SourceUi(
            id = source.id,
            title = source.title,
            content = source.content,
            url = source.url,
            publishedAt = source.publishedAt,
        )
    }

    fun mapToTopicUi(topic: Topic): TopicUi {
        return TopicUi(
            id = topic.id,
            sources = topic.sources.map(TopicMapper::mapToSourceUi),
            title = topic.title,
            summary = topic.summary,
            content = topic.content,
            createdAt = topic.createdAt,
        )
    }
}
