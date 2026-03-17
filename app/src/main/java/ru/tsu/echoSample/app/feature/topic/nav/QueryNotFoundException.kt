package ru.tsu.echoSample.app.feature.topic.nav

class QueryNotFoundException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause)
