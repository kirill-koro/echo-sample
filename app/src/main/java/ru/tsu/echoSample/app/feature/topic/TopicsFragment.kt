package ru.tsu.echoSample.app.feature.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.tsu.echoSample.app.databinding.TopicsFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment
import ru.tsu.echoSample.app.feature.topic.nav.QueryNotFoundException
import ru.tsu.echoSample.app.utils.toolbar

class TopicsFragment : NoParamsFragment<TopicsFragmentBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> TopicsFragmentBinding
        get() = TopicsFragmentBinding::inflate

    @Suppress("UnusedPrivateProperty")
    private val query: String
        get() {
            val message = "Query was not found"
            return requireArguments().getString(QUERY_ARG_KEY)
                ?: throw QueryNotFoundException(message)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
    }

    private fun setupToolbar() {
        toolbar.show()
    }

    companion object {
        private const val QUERY_ARG_KEY = "query"
    }
}
