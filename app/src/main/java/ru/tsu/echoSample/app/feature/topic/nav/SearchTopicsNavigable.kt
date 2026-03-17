package ru.tsu.echoSample.app.feature.topic.nav

interface SearchTopicsNavigable {
    val screenKey: String

    fun onNavigateToTopics(query: String)
}
