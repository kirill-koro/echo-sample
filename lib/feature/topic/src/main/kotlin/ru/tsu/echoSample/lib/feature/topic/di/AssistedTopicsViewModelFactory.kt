package ru.tsu.echoSample.lib.feature.topic.di

import dagger.assisted.AssistedFactory
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicsViewModel
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicsViewModel.Params
import ru.tsu.echoSample.lib.utils.di.viewmodel.Factory

@AssistedFactory
interface AssistedTopicsViewModelFactory : Factory<Params, TopicsViewModel>
