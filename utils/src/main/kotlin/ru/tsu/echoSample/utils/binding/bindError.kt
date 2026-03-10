package ru.tsu.echoSample.utils.binding

import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import dev.icerock.moko.resources.desc.StringDesc
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.flow.StateFlow

fun EditText.bindError(
    lifecycleOwner: LifecycleOwner,
    flow: StateFlow<StringDesc?>,
): DisposableHandle {
    return flow.bind(lifecycleOwner) {
        this.setError(it?.toString(this.context), null)
    }
}
