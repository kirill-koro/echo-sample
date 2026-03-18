package ru.tsu.echoSample.app.feature.profile

import ru.tsu.echoSample.app.R
import ru.tsu.echoSample.app.databinding.ProfileFragmentBinding
import ru.tsu.echoSample.app.di.NoParamsFragment

class ProfileFragment : NoParamsFragment<ProfileFragmentBinding>() {
    override val bind = ProfileFragmentBinding::bind
    override val layoutRes = R.layout.profile_fragment
}
