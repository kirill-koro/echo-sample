package ru.tsu.echoSample.app.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import ru.tsu.echoSample.app.component.utils.ContentBinder
import ru.tsu.echoSample.app.databinding.ScaffoldFragmentBinding

abstract class ScaffoldFragment<VB : ViewBinding> : BoundFragment<VB>() {
    private var _scaffold: ScaffoldFragmentBinding? = null
    private val scaffold: ScaffoldFragmentBinding
        get() = requireNotNull(_scaffold) { "Couldn't read the scaffold on creation" }

    protected abstract val bind: (View) -> VB
    protected abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _scaffold = ScaffoldFragmentBinding.inflate(inflater, container, false)
        val contentBinder = ContentBinder(scaffold.content, layoutRes)
        onBoundContent(content = contentBinder.bind(factory = bind))

        return scaffold.root
    }

    protected fun showProgress() {
        scaffold.progressIndicator.isVisible = true
    }

    protected fun hideProgress() {
        scaffold.progressIndicator.isVisible = false
    }

    protected fun createErrorBinder(@LayoutRes layoutRes: Int): ContentBinder {
        return ContentBinder(scaffold.error, layoutRes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _scaffold = null
    }
}
