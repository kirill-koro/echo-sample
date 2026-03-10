package ru.tsu.echoSample.app.feature.topic

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.tsu.echoSample.app.databinding.SearchTopicsFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment

class SearchTopicsFragment : NoParamsFragment<SearchTopicsFragmentBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> SearchTopicsFragmentBinding
        get() = SearchTopicsFragmentBinding::inflate
}
