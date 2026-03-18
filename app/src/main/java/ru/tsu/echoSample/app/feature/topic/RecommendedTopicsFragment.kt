package ru.tsu.echoSample.app.feature.topic

import android.os.Bundle
import android.view.View
import ru.tsu.echoSample.app.R
import ru.tsu.echoSample.app.databinding.RecommendedTopicsFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment
import ru.tsu.echoSample.app.utils.toolbar

class RecommendedTopicsFragment : NoParamsFragment<RecommendedTopicsFragmentBinding>() {
    override val bind = RecommendedTopicsFragmentBinding::bind
    override val layoutRes = R.layout.recommended_topics_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
    }

    private fun setupToolbar() {
        toolbar.show()
    }
}
