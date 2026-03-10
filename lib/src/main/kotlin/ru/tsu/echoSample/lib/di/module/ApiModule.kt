package ru.tsu.echoSample.lib.di.module

import dagger.Module
import dagger.Provides
import ru.tsu.echoSample.lib.di.qualifiers.BaseUrl
import ru.tsu.echoSample.lib.di.scope.MainScope
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import ru.tsu.echoSample.lib.di.scope.AppScope

@Module
object ApiModule {
    @AppScope
    @Provides
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @AppScope
    @Provides
    fun provideMediaType(): MediaType = "application/json".toMediaType()

    @AppScope
    @Provides
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        json: Json,
        mediaType: MediaType,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                json.asConverterFactory(contentType = mediaType)
            )
            .build()
    }
}
