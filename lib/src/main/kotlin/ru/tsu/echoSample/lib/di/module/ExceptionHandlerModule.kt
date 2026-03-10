package ru.tsu.echoSample.lib.di.module

import dagger.Module
import dagger.Provides
import dev.icerock.moko.errors.handler.ExceptionHandler
import dev.icerock.moko.errors.mappers.ExceptionMappersStorage
import dev.icerock.moko.errors.presenters.SelectorErrorPresenter
import dev.icerock.moko.errors.presenters.SnackBarDuration
import dev.icerock.moko.errors.presenters.SnackBarErrorPresenter
import io.github.aakira.napier.Napier

@Module
object ExceptionHandlerModule {
    @Provides
    fun provideSnackbarErrorPresenter(): SnackBarErrorPresenter {
        return SnackBarErrorPresenter(duration = SnackBarDuration.SHORT)
    }

    @Provides
    fun provideExceptionHandler(
        snackBarErrorPresenter: SnackBarErrorPresenter,
    ): ExceptionHandler {
        return ExceptionHandler(
            exceptionMapper = ExceptionMappersStorage.throwableMapper(),
            errorPresenter = SelectorErrorPresenter { throwable ->
                snackBarErrorPresenter
            },
            onCatch = { e -> Napier.e("New error was caught", e) }
        )
    }
}
