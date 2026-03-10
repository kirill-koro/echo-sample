package ru.tsu.echoSample.app.feature.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.tsu.echoSample.app.databinding.SearchTopicsFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment
import ru.tsu.echoSample.app.utils.toolbar

class SearchTopicsFragment : NoParamsFragment<SearchTopicsFragmentBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> SearchTopicsFragmentBinding
        get() = SearchTopicsFragmentBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
    }

    private fun setupToolbar() {
        toolbar.hide()
    }
}
