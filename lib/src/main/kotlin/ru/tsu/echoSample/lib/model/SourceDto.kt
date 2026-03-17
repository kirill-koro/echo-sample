package ru.tsu.echoSample.lib.model

import kotlinx.serialization.Serializable

@Serializable
data class SourceDto(
    val id: Int,
    val title: String,
    val content: String,
    val url: String,
    val publishedAt: Int,
) {
    companion object {
        fun create(id: Int): SourceDto {
            return SourceDto(
                id = id,
                title = "Title ${(0..100).random()}",
                content = "Content",
                url = "https://sample.ru",
                publishedAt = (0..100_000).random(),
            )
        }
    }
}
