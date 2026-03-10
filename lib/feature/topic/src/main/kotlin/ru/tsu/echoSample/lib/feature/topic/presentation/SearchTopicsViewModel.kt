package ru.tsu.echoSample.lib.feature.topic.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.icerock.moko.errors.handler.ExceptionHandler
import dev.icerock.moko.errors.mappers.mapThrowable
import dev.icerock.moko.fields.core.validations.notBlank
import dev.icerock.moko.fields.flow.FormField
import dev.icerock.moko.fields.flow.validations.fieldValidation
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.tsu.echoSample.i18n.MR
import ru.tsu.echoSample.lib.feature.topic.validation.InvalidSearchQueryException
import ru.tsu.echoSample.lib.utils.di.viewmodel.sendAction
import javax.inject.Inject

class SearchTopicsViewModel @Inject constructor(
    val exceptionHandler: ExceptionHandler,
) : ViewModel() {
    val searchField = FormField(
        scope = viewModelScope,
        initialValue = SEARCH_DEFAULT_VALUE,
        validation = fieldValidation {
            notBlank(MR.strings.search_topics_search_field_error.desc())
        },
    )

    private val _state = MutableStateFlow<State>(State.Idle)
    val state = _state.asStateFlow()

    private val _actions = Channel<Actions>()
    val actions = _actions.receiveAsFlow()

    fun onSearchButtonClicked() {
        if (_state.value is State.Pending) return

        _state.update { State.Pending }
        viewModelScope.launch {
            exceptionHandler.handle {
                if (searchField.validate().not()) throw InvalidSearchQueryException()

                onSearchSuccess()
            }.catch<Exception> { e ->
                val reason: StringDesc = e.mapThrowable()
                onSearchFailure(reason)
                false
            }.execute()
        }
    }

    private fun onSearchSuccess() {
        sendAction(_actions, Actions.NavigateToTopics(query = searchField.value().trim()))
        _state.update { State.Idle }
    }

    private fun onSearchFailure(reason: StringDesc) {
        searchField.setError(reason)
        _state.update { State.ValidationFailed }
    }

    fun onKeyboardReturnButtonClicked() {
        onSearchButtonClicked()
    }

    sealed interface State {
        data object Idle : State

        data object Pending : State

        data object ValidationFailed : State
    }

    sealed interface Actions {
        data class NavigateToTopics(val query: String) : Actions
    }

    companion object {
        private const val SEARCH_DEFAULT_VALUE = ""
    }
}
