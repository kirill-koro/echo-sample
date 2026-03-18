package ru.tsu.echoSample.lib.model

import kotlinx.serialization.Serializable

@Serializable
data class TopicDto(
    val id: Int,
    val sources: List<SourceDto>,
    val title: String,
    val summary: String,
    val content: String,
    val createdAt: Int,
) {
    init {
        require(sources.isNotEmpty()) { "There must be at least one source" }
    }

    companion object {
        @Suppress("MagicNumber")
        fun create(
            id: Int,
            title: String,
            summary: String,
            content: String,
        ): TopicDto {
            return TopicDto(
                id = id,
                sources = List((1..5).random(), SourceDto::create),
                title = title,
                summary = summary,
                content = content,
                createdAt = (0..100_000).random(),
            )
        }
    }
}
