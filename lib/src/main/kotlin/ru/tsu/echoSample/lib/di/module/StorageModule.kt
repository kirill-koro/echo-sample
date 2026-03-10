package ru.tsu.echoSample.lib.di.module

import dagger.Binds
import dagger.Module
import ru.tsu.echoSample.lib.storage.EncryptedKeyValueStorage
import ru.tsu.echoSample.lib.storage.KeyValueStorage

@Module
interface StorageModule {
    // TODO: Bind a feature-specific app storage interface

    @Binds
    fun bindEncryptedKeyValueStorage(
        implementation: EncryptedKeyValueStorage,
    ): EncryptedKeyValueStorage

    @Binds
    fun bindKeyValueStorage(implementation: KeyValueStorage): KeyValueStorage
}
