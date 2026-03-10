package ru.tsu.echoSample.app.utils

import androidx.annotation.IdRes
import ru.tsu.echoSample.app.R

internal sealed interface Destination {
    @get:IdRes
    val actionId: Int

    data object AssistedSample : Destination {
        override val actionId: Int = R.id.toAssistedSampleFragmentAction
    }
}
