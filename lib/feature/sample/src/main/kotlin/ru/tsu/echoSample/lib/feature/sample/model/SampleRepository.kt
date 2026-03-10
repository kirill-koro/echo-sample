package ru.tsu.echoSample.lib.feature.sample.model

interface SampleRepository {
    suspend fun get()

    suspend fun get(name: String)
}
