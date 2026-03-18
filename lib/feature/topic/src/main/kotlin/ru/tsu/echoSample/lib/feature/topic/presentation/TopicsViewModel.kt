package ru.tsu.echoSample.lib.feature.topic.presentation

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import javax.inject.Inject

class TopicsViewModel @Inject constructor(
    @Assisted
    private val params: Params,
) : ViewModel() {
    fun onStart() {

    }

    data class Params(val query: String)
}
