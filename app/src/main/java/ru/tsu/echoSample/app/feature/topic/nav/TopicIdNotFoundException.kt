package ru.tsu.echoSample.app.feature.topic.nav

class TopicIdNotFoundException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause)
