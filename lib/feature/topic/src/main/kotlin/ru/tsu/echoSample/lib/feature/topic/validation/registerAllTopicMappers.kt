package ru.tsu.echoSample.lib.feature.topic.validation

import dev.icerock.moko.errors.mappers.ExceptionMappersStorage
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import ru.tsu.echoSample.i18n.MR

fun ExceptionMappersStorage.registerAllTopicMappers(): ExceptionMappersStorage {
    return register<InvalidSearchQueryException, StringDesc> {
        MR.strings.search_topics_search_field_error.desc()
    }
}
