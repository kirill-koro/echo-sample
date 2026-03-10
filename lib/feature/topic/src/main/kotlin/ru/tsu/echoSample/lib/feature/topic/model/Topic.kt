package ru.tsu.echoSample.lib.feature.topic.model

data class Topic(
    val id: Int,
    val sources: List<Source>,
    val title: String,
    val summary: String,
    val content: String,
    val createdAt: Int,
) {
    init {
        require(sources.isNotEmpty()) { "There must be at least one source" }
    }
}
