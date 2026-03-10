package ru.tsu.echoSample.app.feature.topic

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.tsu.echoSample.app.databinding.TopicsFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment

class TopicsFragment : NoParamsFragment<TopicsFragmentBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> TopicsFragmentBinding
        get() = TopicsFragmentBinding::inflate
}
