package ru.tsu.echoSample.app.feature.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.tsu.echoSample.app.databinding.AssistedSampleFragmentBinding
import ru.tsu.echoSample.app.di.ParamsFragment
import ru.tsu.echoSample.lib.feature.sample.di.AssistedSampleViewModelFactory
import ru.tsu.echoSample.lib.feature.sample.presentation.AssistedSampleViewModel

class AssistedSampleFragment :
    ParamsFragment<AssistedSampleViewModelFactory, AssistedSampleFragmentBinding>() {
    private val viewModel: AssistedSampleViewModel by getViewModel {
        AssistedSampleViewModel.Params(name = "passed info")
    }

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> AssistedSampleFragmentBinding
        get() = AssistedSampleFragmentBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onStart()
    }
}
