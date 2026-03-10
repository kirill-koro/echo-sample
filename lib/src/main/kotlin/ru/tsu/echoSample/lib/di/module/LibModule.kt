package ru.tsu.echoSample.lib.di.module

import dagger.Module

@Module(
    includes = [
        FeatureModule::class,
        ApiModule::class,
        RepositoryModule::class,
        ExceptionHandlerModule::class,
        SqlDelightModule::class,
        PlatformModule::class,
        StorageModule::class,
    ]
)
interface LibModule
