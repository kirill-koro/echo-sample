package ru.tsu.echoSample.lib.feature.topic.validation

internal class InvalidSearchQueryException(
    message: String = "Search query is not valid",
    cause: Throwable? = null,
) : RuntimeException(message, cause)
