package ru.tsu.echoSample.app.feature.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.navigation.NavDeepLinkRequest
import ru.tsu.echoSample.app.databinding.SearchTopicsFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment
import ru.tsu.echoSample.app.feature.topic.nav.SearchTopicsNavigable
import ru.tsu.echoSample.app.utils.requireMainNavHostFragment
import ru.tsu.echoSample.app.utils.toolbar
import ru.tsu.echoSample.lib.feature.topic.presentation.SearchTopicsViewModel
import ru.tsu.echoSample.lib.feature.topic.presentation.SearchTopicsViewModel.Actions
import ru.tsu.echoSample.lib.feature.topic.presentation.SearchTopicsViewModel.State
import ru.tsu.echoSample.utils.binding.bind
import ru.tsu.echoSample.utils.binding.bindTextTwoWay
import ru.tsu.echoSample.utils.nav.DeepLinkRegistry

class SearchTopicsFragment :
    NoParamsFragment<SearchTopicsFragmentBinding>(),
    SearchTopicsNavigable {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> SearchTopicsFragmentBinding
        get() = SearchTopicsFragmentBinding::inflate

    private val viewModel: SearchTopicsViewModel by getViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupExceptionHandler()
        setupToolbar()
        setupComponents()
        setupCollectors()
    }

    private fun setupExceptionHandler() {
        viewModel.exceptionHandler.bind(viewLifecycleOwner, requireActivity())
    }

    private fun setupToolbar() {
        toolbar.hide()
    }

    private fun setupComponents() {
        setupSearch()
    }

    private fun setupSearch() {
        binding.searchContent.editText.bindTextTwoWay(
            lifecycleOwner = viewLifecycleOwner,
            flow = viewModel.searchField.data,
        )
        binding.searchContent.editText.setOnEditorActionListener { _, actionId, _ ->
            onKeyboardEditorActionClicked(actionId)
        }
    }

    private fun setupCollectors() {
        collectState()
        collectActions()
    }

    private fun collectState() {
        viewModel.state.bind(viewLifecycleOwner) { state ->
            binding.searchContent.editText.isEnabled = state != State.Pending
        }
    }

    private fun collectActions() {
        viewModel.actions.bind(viewLifecycleOwner) { action ->
            when (action) {
                is Actions.NavigateToTopics -> onNavigateToTopics(action.query)
            }
        }
    }

    override fun onNavigateToTopics(query: String) {
        val uri = DeepLinkRegistry.Request(screenKey)
            .query(query)
            .uri
        val topics = NavDeepLinkRequest.Builder
            .fromUri(uri)
            .build()
        val navController = requireMainNavHostFragment().navController
        navController.navigate(topics)
    }

    private fun onKeyboardEditorActionClicked(actionId: Int): Boolean {
        return if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            viewModel.onImeActionButtonClicked()
            true
        } else {
            false
        }
    }

    override val screenKey = "topics"
}
