package ru.tsu.echoSample.app.feature.topic

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import ru.tsu.echoSample.app.R
import ru.tsu.echoSample.app.databinding.TopicDetailsFragmentBinding
import ru.tsu.echoSample.app.di.ParamsFragment
import ru.tsu.echoSample.app.feature.topic.mapper.TopicMapper
import ru.tsu.echoSample.app.feature.topic.nav.TopicDetailsNavigable
import ru.tsu.echoSample.app.feature.topic.nav.TopicIdNotFoundException
import ru.tsu.echoSample.app.utils.toolbar
import ru.tsu.echoSample.lib.feature.topic.di.AssistedTopicDetailsViewModelFactory
import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicDetailsViewModel
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicDetailsViewModel.Actions
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicDetailsViewModel.State
import ru.tsu.echoSample.utils.binding.bind
import ru.tsu.echoSample.utils.nav.DeepLinkRegistry

class TopicDetailsFragment :
    ParamsFragment<AssistedTopicDetailsViewModelFactory, TopicDetailsFragmentBinding>(),
    TopicDetailsNavigable {
    private val viewModel: TopicDetailsViewModel by getViewModel {
        TopicDetailsViewModel.Params(topicId)
    }

    private val topicId: Int
        get() {
            val message = "Topic id was not found"
            val topicId = requireArguments().getInt(TOPIC_ID_ARG_KEY, -1)
            if (topicId != -1) return topicId else throw TopicIdNotFoundException(message)
        }

    override val bind = TopicDetailsFragmentBinding::bind
    override val layoutRes = R.layout.topic_details_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupCollectors()

        viewModel.onStart()
    }

    private fun setupToolbar() {
        toolbar.show()
        addMenuProvider()
    }

    private fun addMenuProvider() {
        val provider = object : MenuProvider {
            override fun onCreateMenu(
                menu: Menu,
                menuInflater: MenuInflater
            ) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_compare -> {
                        viewModel.onCompareButtonClicked()
                        true
                    }

                    R.id.action_share -> {
                        viewModel.onShareButtonClicked()
                        true
                    }

                    else -> false
                }
            }
        }
        requireActivity().addMenuProvider(provider, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setupCollectors() {
        collectState()
        collectActions()
    }

    private fun collectState() {
        viewModel.state.bind(viewLifecycleOwner) { state ->
            content.root.isVisible = state is State.Loaded

            if (state == State.Fetching) showProgress() else hideProgress()
            if (state is State.Loaded) {
                onLoadedState(state.topic)
            }
        }
    }

    private fun collectActions() {
        viewModel.actions.bind(viewLifecycleOwner) { action ->
            when (action) {
                Actions.NavigateToSourceComparator -> onNavigateToComparator()

                Actions.Share -> onShare()
            }
        }
    }

    private fun onShare() {
        val url = "https://topic-details?id=$topicId/echo.tsu.ru"
        val clipboard = requireActivity()
            .getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
        val clip = ClipData.newPlainText("Topic url", url)
        clipboard?.setPrimaryClip(clip)
    }

    private fun onLoadedState(topic: Topic) {
        val topicUi = TopicMapper.mapToTopicUi(topic)
        content.title.text = topicUi.title
        content.summary.text = topicUi.summary
        content.content.text = topicUi.content
    }

    override fun onNavigateToComparator() {
        val comparator = NavDeepLinkRequest.Builder
            .fromUri(DeepLinkRegistry.Request(screenKey).uri)
            .build()
        findNavController().navigate(comparator)
    }

    override val screenKey = "comparator"

    companion object {
        private const val TOPIC_ID_ARG_KEY = "id"
    }
}
