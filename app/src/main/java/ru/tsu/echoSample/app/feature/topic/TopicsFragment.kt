package ru.tsu.echoSample.app.feature.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.tsu.echoSample.app.databinding.TopicsFragmentBinding
import ru.tsu.echoSample.app.di.ParamsFragment
import ru.tsu.echoSample.app.feature.topic.nav.QueryNotFoundException
import ru.tsu.echoSample.app.utils.toolbar
import ru.tsu.echoSample.lib.feature.topic.di.AssistedTopicsViewModelFactory
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicsViewModel

class TopicsFragment : ParamsFragment<AssistedTopicsViewModelFactory, TopicsFragmentBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> TopicsFragmentBinding
        get() = TopicsFragmentBinding::inflate

    private val query: String
        get() {
            val message = "Query was not found"
            return requireArguments().getString(QUERY_ARG_KEY)
                ?: throw QueryNotFoundException(message)
        }

    private val viewModel: TopicsViewModel by getViewModel { TopicsViewModel.Params(query) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()

        viewModel.onStart()
    }

    private fun setupToolbar() {
        toolbar.show()
    }

    companion object {
        private const val QUERY_ARG_KEY = "query"
    }
}
