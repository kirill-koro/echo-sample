package ru.tsu.echoSample.lib.repository

import javax.inject.Inject

class AppRepository @Inject constructor() : FeatureRepository {
    override suspend fun get() = Unit

    override suspend fun get(name: String) = Unit
}
