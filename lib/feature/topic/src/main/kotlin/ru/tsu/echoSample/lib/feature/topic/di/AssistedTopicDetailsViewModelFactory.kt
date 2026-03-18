package ru.tsu.echoSample.lib.feature.topic.di

import dagger.assisted.AssistedFactory
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicDetailsViewModel
import ru.tsu.echoSample.lib.feature.topic.presentation.TopicDetailsViewModel.Params
import ru.tsu.echoSample.lib.utils.di.viewmodel.Factory

@AssistedFactory
interface AssistedTopicDetailsViewModelFactory : Factory<Params, TopicDetailsViewModel>
