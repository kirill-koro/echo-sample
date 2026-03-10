package ru.tsu.echoSample.app.feature.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.tsu.echoSample.app.databinding.ProfileFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment

class ProfileFragment : NoParamsFragment<ProfileFragmentBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> ProfileFragmentBinding
        get() = ProfileFragmentBinding::inflate
}
