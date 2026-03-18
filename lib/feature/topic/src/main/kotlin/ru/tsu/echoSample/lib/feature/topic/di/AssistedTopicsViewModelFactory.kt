package ru.tsu.echoSample.lib.feature.topic.di

import dagger.assisted.AssistedFactory
import ru.tsu.echoSample.lib.feature.topic.presentation.BrowsedTopicsViewModel
import ru.tsu.echoSample.lib.feature.topic.presentation.BrowsedTopicsViewModel.Params
import ru.tsu.echoSample.lib.utils.di.viewmodel.Factory

@AssistedFactory
interface AssistedTopicsViewModelFactory : Factory<Params, BrowsedTopicsViewModel>
