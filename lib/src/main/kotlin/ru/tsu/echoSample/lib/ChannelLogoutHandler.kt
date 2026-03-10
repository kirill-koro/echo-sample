package ru.tsu.echoSample.lib

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import ru.tsu.echoSample.lib.utils.logout.LogoutHandler

class ChannelLogoutHandler : LogoutHandler {
    private val logoutEventsChannel = Channel<Unit>()

    override val logoutEvents: Flow<Unit>
        get() = logoutEventsChannel.receiveAsFlow()

    override suspend fun onLogout() {
        logoutEventsChannel.send(Unit)
    }
}
