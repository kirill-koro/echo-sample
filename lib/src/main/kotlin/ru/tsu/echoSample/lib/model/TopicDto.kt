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
        fun create(id: Int): TopicDto {
            return TopicDto(
                id = id,
                sources = List((0..5).random(), SourceDto::create),
                title = "Title ${(0..100).random()}",
                summary = "Summary",
                content = "Content",
                createdAt = (0..100_000).random(),
            )
        }
    }
}
