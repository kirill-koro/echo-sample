package ru.tsu.echoSample.utils.nav

import android.net.Uri
import androidx.core.net.toUri

sealed class DeepLinkRegistry {
    internal val prefix = "echo://ru.tsu"

    data class Request(private val screenKey: String) : DeepLinkRegistry() {
        private var raw = "$prefix/$screenKey"
        val uri: Uri
            get() = raw.toUri()

        fun query(value: String): Request {
            raw += "?q=$value"
            return this
        }
    }
}
