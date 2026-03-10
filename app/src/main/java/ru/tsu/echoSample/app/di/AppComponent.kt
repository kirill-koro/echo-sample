package ru.tsu.echoSample.app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ru.tsu.echoSample.lib.di.module.LibModule
import ru.tsu.echoSample.lib.di.qualifier.AppContext
import ru.tsu.echoSample.lib.di.qualifier.BaseUrl
import ru.tsu.echoSample.lib.di.scope.AppScope

@AppScope
@Component(
    modules = [
        LibModule::class,
        ActivityModule::class,
        AndroidInjectionModule::class,
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun baseUrl(@BaseUrl baseUrl: String): Builder

        @BindsInstance
        fun appContext(@AppContext context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(application: DaggerApp)
}
