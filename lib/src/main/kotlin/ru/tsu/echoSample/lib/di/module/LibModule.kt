package ru.tsu.echoSample.lib.di.module

import dagger.Module

@Module(
    includes = [
        FeatureModule::class,
        ExceptionHandlerModule::class,
    ]
)
interface LibModule
