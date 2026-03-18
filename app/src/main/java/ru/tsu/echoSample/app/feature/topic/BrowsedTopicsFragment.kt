package ru.tsu.echoSample.app.feature.topic

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import ru.tsu.echoSample.app.R
import ru.tsu.echoSample.app.databinding.BrowsedTopicsFragmentBinding
import ru.tsu.echoSample.app.databinding.NoTopicsFragmentBinding
import ru.tsu.echoSample.app.di.ParamsFragment
import ru.tsu.echoSample.app.feature.topic.mapper.TopicMapper
import ru.tsu.echoSample.app.feature.topic.nav.BrowsedTopicsNavigable
import ru.tsu.echoSample.app.feature.topic.nav.QueryNotFoundException
import ru.tsu.echoSample.app.utils.toolbar
import ru.tsu.echoSample.lib.feature.topic.di.AssistedTopicsViewModelFactory
import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.feature.topic.presentation.BrowsedTopicsViewModel
import ru.tsu.echoSample.lib.feature.topic.presentation.BrowsedTopicsViewModel.Actions
import ru.tsu.echoSample.lib.feature.topic.presentation.BrowsedTopicsViewModel.State
import ru.tsu.echoSample.utils.binding.bind
import ru.tsu.echoSample.utils.nav.DeepLinkRegistry

class BrowsedTopicsFragment :
    ParamsFragment<AssistedTopicsViewModelFactory, BrowsedTopicsFragmentBinding>(),
    BrowsedTopicsNavigable {
    private val viewModel: BrowsedTopicsViewModel by getViewModel {
        BrowsedTopicsViewModel.Params(query)
    }

    private val query: String
        get() {
            val message = "Query was not found"
            return requireArguments().getString(QUERY_ARG_KEY)
                ?: throw QueryNotFoundException(message)
        }

    override val bind = BrowsedTopicsFragmentBinding::bind
    override val layoutRes = R.layout.browsed_topics_fragment

    private var adapter: BrowsedTopicsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupComponents()
        setupCollectors()

        viewModel.onStart()
    }

    private fun setupToolbar() {
        toolbar.show()
    }

    private fun setupComponents() {
        setupErrorComponent()
    }

    private fun setupCollectors() {
        collectState()
        collectActions()
    }

    private fun collectState() {
        viewModel.state.bind(viewLifecycleOwner) { state ->
            content.root.isVisible = state is State.Loaded
            errorAs<NoTopicsFragmentBinding>().root.isVisible = state == State.Empty

            if (state == State.Fetching) showProgress() else hideProgress()
            if (state is State.Loaded) {
                onLoadedState(state.topics)
            }
        }
    }

    private fun collectActions() {
        viewModel.actions.bind(viewLifecycleOwner) { action ->
            when (action) {
                is Actions.NavigateToTopicDetails -> onNavigateToTopicDetails(action.id)
            }
        }
    }

    private fun setupErrorComponent() {
        val errorBinder = createErrorBinder(R.layout.no_topics_fragment)
        onBindError(error = errorBinder.bind(factory = NoTopicsFragmentBinding::bind))
    }

    private fun onLoadedState(topics: List<Topic>) {
        createAdapterIfNeeded()
        adapter?.items = topics.map(TopicMapper::mapToTopicUi)
    }

    private fun createAdapterIfNeeded() {
        if (adapter == null) {
            adapter = BrowsedTopicsAdapter(viewModel::onTopicSelected)
        }
        val context = content.topics.context
        val layoutManager = LinearLayoutManager(requireContext())
        val divider = MaterialDividerItemDecoration(context, layoutManager.orientation)
        content.topics.adapter = adapter
        content.topics.layoutManager = layoutManager
        content.topics.addItemDecoration(divider)
    }

    override fun onNavigateToTopicDetails(id: Int) {
        val uri = DeepLinkRegistry.Request(screenKey)
            .id(id)
            .uri
        val topicDetails = NavDeepLinkRequest.Builder
            .fromUri(uri)
            .build()
        findNavController().navigate(topicDetails)
    }

    override val screenKey = "topic-details"

    companion object Companion {
        private const val QUERY_ARG_KEY = "query"
    }
}
