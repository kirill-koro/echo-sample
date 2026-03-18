package ru.tsu.echoSample.app.component

import androidx.viewbinding.ViewBinding
import ru.tsu.echoSample.app.di.DaggerFragment

open class BoundFragment<VB : ViewBinding> : DaggerFragment<VB>() {
    private var _content: VB? = null
    protected val content: VB
        get() = requireNotNull(_content) { "Couldn't read the content on creation" }

    private var _error: ViewBinding? = null
    private val error: ViewBinding
        get() = requireNotNull(_error) { "Couldn't read the binding on creation" }

    protected fun onBoundContent(content: VB) {
        _content = content
    }

    protected fun onBoundError(error: ViewBinding) {
        _error = error
    }

    @Suppress("UNCHECKED_CAST")
    protected fun <T : ViewBinding> errorAs(): T {
        val error = this.error as? T
        requireNotNull(error) { "Couldn't cast the error binding" }
        return error
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _content = null
        _error = null
    }
}
