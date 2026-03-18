package ru.tsu.echoSample.lib.feature.topic.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.tsu.echoSample.lib.feature.topic.interactor.GetTopic
import ru.tsu.echoSample.lib.feature.topic.model.Topic
import ru.tsu.echoSample.lib.utils.di.viewmodel.sendAction

class TopicDetailsViewModel @AssistedInject constructor(
    @Assisted private val params: Params,
    private val getTopic: GetTopic,
) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Idle)
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
                val topic = getTopic.await(params.topicId)

                onFetchSuccess(topic)
            } catch (_: Exception) {
                ensureActive()
                onFetchFailure()
            }
        }
    }

    private fun onFetchSuccess(topic: Topic) {
        _state.update { State.Loaded(topic) }
    }

    private fun onFetchFailure() {
        _state.update { State.Failed }
    }

    fun onCompareButtonClicked() {
        sendAction(_actions, Actions.NavigateToSourceComparator)
    }

    fun onShareButtonClicked() {
        sendAction(_actions, Actions.Share)
    }

    sealed interface State {
        data object Idle : State

        data object Fetching : State

        data class Loaded(val topic: Topic) : State

        data object Failed : State
    }

    sealed interface Actions {
        data object NavigateToSourceComparator : Actions

        data object Share : Actions
    }

    data class Params(val topicId: Int)
}
