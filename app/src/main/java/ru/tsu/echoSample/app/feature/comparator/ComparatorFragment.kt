package ru.tsu.echoSample.app.feature.comparator

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.content.ContextCompat
import ru.tsu.echoSample.app.R
import ru.tsu.echoSample.app.databinding.ComparatorFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment
import ru.tsu.echoSample.app.utils.toolbar
import ru.tsu.echoSample.i18n.MR

class ComparatorFragment : NoParamsFragment<ComparatorFragmentBinding>() {
    override val bind = ComparatorFragmentBinding::bind
    override val layoutRes = R.layout.comparator_fragment

    private var activeScrollContent: View? = null

    private val scrollListener = ViewTreeObserver.OnScrollChangedListener {
        if (isAdded.not() || view == null) return@OnScrollChangedListener

        activeScrollContent?.let {
            val other = if (content.top == it) content.bottom else content.top
            other.scrollTo(it.scrollX, it.scrollY)
        }
    }
    private val touchListener = View.OnTouchListener { view, _ ->
        activeScrollContent = view
        false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupComponents()
    }

    private fun setupToolbar() {
        toolbar.show()

        val resId = MR.strings.comparator_toolbar.resourceId
        toolbar.title = ContextCompat.getString(requireContext(), resId)
    }

    private fun setupComponents() {
        setupScrollContentComponents()
    }

    private fun setupScrollContentComponents() {
        listOf(content.top, content.bottom).forEach { scrollContent ->
            scrollContent.viewTreeObserver.addOnScrollChangedListener(scrollListener)
            scrollContent.setOnTouchListener(touchListener)
        }
    }

    private fun resetToolbar() {
        toolbar.title = ContextCompat.getString(requireContext(), R.string.app_name)
    }

    private fun clearScrollContentComponents() {
        listOf(content.top, content.bottom).forEach { scrollContent ->
            scrollContent.viewTreeObserver.removeOnScrollChangedListener(scrollListener)
            scrollContent.setOnTouchListener(null)
        }
        activeScrollContent = null
    }

    override fun onDestroyView() {
        resetToolbar()
        clearScrollContentComponents()
        super.onDestroyView()
    }
}
