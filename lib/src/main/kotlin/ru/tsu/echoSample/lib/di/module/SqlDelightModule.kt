package ru.tsu.echoSample.lib.di.module

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import dagger.Module
import dagger.Provides
import ru.tsu.echoSample.lib.di.qualifiers.AppContext
import ru.tsu.echoSample.lib.di.scope.AppScope
import ru.tsu.echoSample.lib.sample.SampleDatabase

@Module
object SqlDelightModule {
    @AppScope
    @Provides
    fun provideSqlDriver(@AppContext context: Context): SqlDriver {
        return AndroidSqliteDriver(SampleDatabase.Schema, context, SAMPLE_DB_NAME)
    }
}

private const val SAMPLE_DB_NAME = "sample.db"
