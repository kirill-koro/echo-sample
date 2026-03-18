package ru.tsu.echoSample.app.feature.topic.nav

interface BrowsedTopicsNavigable {
    val screenKey: String

    fun onNavigateToTopicDetails(id: Int)
}
