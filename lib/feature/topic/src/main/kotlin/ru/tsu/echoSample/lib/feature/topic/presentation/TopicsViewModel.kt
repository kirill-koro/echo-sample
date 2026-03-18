package ru.tsu.echoSample.lib.feature.topic.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.tsu.echoSample.lib.feature.topic.interactor.GetTopics
import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.utils.di.viewmodel.sendAction
import javax.inject.Inject

class TopicsViewModel @Inject constructor(
    @Assisted
    private val params: Params,
    private val getTopics: GetTopics,
) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Fetching)
    val state = _state.asStateFlow()

    private val _actions = Channel<Actions>()
    val actions = _actions.receiveAsFlow()

    fun onStart() {
        onFetch()
    }

    private fun onFetch() {
        if (_state.value is State.Fetching) return

        _state.update { State.Fetching }
        viewModelScope.launch {
            try {
                val topics = getTopics.await()

                onFetchSuccess(topics)
            } catch (_: Exception) {
                ensureActive()
                onFetchFailure()
            }
        }
    }

    private fun onFetchSuccess(topics: List<Topic>) {
        val state = if (topics.isEmpty()) State.Empty else State.Loaded(topics)
        _state.update { state }
    }

    private fun onFetchFailure() {
        _state.update { State.Failed }
    }

    fun onTopicSelected(id: Int) {
        sendAction(_actions, Actions.NavigateToTopic(id))
    }

    sealed interface State {
        data object Fetching : State

        data class Loaded(val topics: List<Topic>) : State

        data object Failed : State

        data object Empty : State
    }

    sealed interface Actions {
        data class NavigateToTopic(val id: Int) : Actions
    }

    data class Params(val query: String)
}
