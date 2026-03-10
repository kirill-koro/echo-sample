package ru.tsu.echoSample.lib.feature.sample.di

import dagger.assisted.AssistedFactory
import ru.tsu.echoSample.lib.feature.sample.presentation.AssistedSampleViewModel
import ru.tsu.echoSample.lib.feature.sample.presentation.AssistedSampleViewModel.Params
import ru.tsu.echoSample.lib.utils.di.viewmodel.Factory

@AssistedFactory
interface AssistedSampleViewModelFactory : Factory<Params, AssistedSampleViewModel>
