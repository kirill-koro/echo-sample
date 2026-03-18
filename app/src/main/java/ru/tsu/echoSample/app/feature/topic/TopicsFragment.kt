package ru.tsu.echoSample.app.feature.topic

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import ru.tsu.echoSample.app.R
import ru.tsu.echoSample.app.databinding.NoTopicsFragmentBinding
import ru.tsu.echoSample.app.databinding.TopicsFragmentBinding
import ru.tsu.echoSample.app.di.ParamsFragment
import ru.tsu.echoSample.app.feature.topic.mapper.TopicMapper
import ru.tsu.echoSample.app.feature.topic.nav.QueryNotFoundException
import ru.tsu.echoSample.app.utils.toolbar
import ru.tsu.echoSample.lib.feature.topic.di.AssistedTopicsViewModelFactory
import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicsViewModel
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicsViewModel.Actions
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicsViewModel.State
import ru.tsu.echoSample.utils.binding.bind

class TopicsFragment : ParamsFragment<AssistedTopicsViewModelFactory, TopicsFragmentBinding>() {
    private val viewModel: TopicsViewModel by getViewModel { TopicsViewModel.Params(query) }

    private val query: String
        get() {
            val message = "Query was not found"
            return requireArguments().getString(QUERY_ARG_KEY)
                ?: throw QueryNotFoundException(message)
        }

    override val bind = TopicsFragmentBinding::bind
    override val layoutRes = R.layout.topics_fragment

    private var adapter: TopicsAdapter? = null

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
                is Actions.NavigateToTopic -> {
                    // TODO:
                }
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
            adapter = TopicsAdapter(viewModel::onTopicSelected)
        }
        val context = content.topics.context
        val layoutManager = LinearLayoutManager(requireContext())
        val divider = MaterialDividerItemDecoration(context, layoutManager.orientation)
        content.topics.adapter = adapter
        content.topics.layoutManager = layoutManager
        content.topics.addItemDecoration(divider)
    }

    companion object {
        private const val QUERY_ARG_KEY = "query"
    }
}
