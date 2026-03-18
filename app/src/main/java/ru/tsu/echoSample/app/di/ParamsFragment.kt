package ru.tsu.echoSample.app.di

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import ru.tsu.echoSample.app.component.ScaffoldFragment
import ru.tsu.echoSample.lib.utils.di.viewmodel.Factory
import ru.tsu.echoSample.lib.utils.di.viewmodel.getViewModel
import javax.inject.Inject

abstract class ParamsFragment<F : Factory<*, *>, VB : ViewBinding> : ScaffoldFragment<VB>() {
    @Inject
    lateinit var assistedFactory: F

    inline fun <P, reified VM : ViewModel> getViewModel(crossinline getParams: () -> P): Lazy<VM> {
        return getViewModel(
            injectFactory = {
                @Suppress("UNCHECKED_CAST")
                assistedFactory as Factory<P, VM>
            },
            getParams = getParams,
        )
    }
}
