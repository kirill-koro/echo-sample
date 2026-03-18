package ru.tsu.echoSample.app.feature.topic.model

data class TopicUi(
    val id: Int,
    val sources: List<SourceUi>,
    val title: String,
    val summary: String,
    val content: String,
    val createdAt: Int,
) {
    init {
        require(sources.isNotEmpty()) { "There must be at least one source" }
    }
}
