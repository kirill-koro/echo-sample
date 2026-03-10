package ru.tsu.echoSample.lib.di

import dev.icerock.moko.errors.mappers.ExceptionMappersStorage
import dev.icerock.moko.network.errors.registerAllNetworkMappers
import io.github.aakira.napier.Napier
import ru.tsu.echoSample.lib.feature.topic.validation.registerAllTopicMappers

fun configureExceptionMappers() {
    ExceptionMappersStorage
        .registerAllNetworkMappers()
        .registerAllTopicMappers()
        .onEach { e, _, _ -> Napier.e("New exception was mapped", e) }
}
