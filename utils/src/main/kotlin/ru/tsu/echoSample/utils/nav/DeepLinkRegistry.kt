package ru.tsu.echoSample.utils.nav

import android.net.Uri
import androidx.core.net.toUri

sealed class DeepLinkRegistry {
    internal val prefix = "echo://ru.tsu"

    data class Request(private val destination: String) : DeepLinkRegistry() {
        val uri: Uri
            get() = "$prefix/$destination".toUri()
    }
}
