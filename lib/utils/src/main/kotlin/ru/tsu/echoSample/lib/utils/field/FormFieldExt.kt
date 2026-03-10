package ru.tsu.echoSample.lib.utils.field

import dev.icerock.moko.fields.flow.flowBlock
import dev.icerock.moko.resources.desc.StringDesc
import kotlinx.coroutines.flow.Flow

fun <D> noValidation(): (Flow<D>) -> Flow<StringDesc?> = flowBlock<D, StringDesc?> { null }
