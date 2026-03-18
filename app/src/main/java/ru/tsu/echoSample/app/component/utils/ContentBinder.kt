package ru.tsu.echoSample.app.component.utils

import android.view.View
import android.view.ViewStub
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

class ContentBinder {
    private val contentStub: ViewStub

    constructor(contentStub: ViewStub, @LayoutRes layoutRes: Int) {
        this.contentStub = contentStub
        this.contentStub.layoutResource = layoutRes
    }

    fun <VB : ViewBinding> bind(factory: BindingFactory<VB>): VB {
        return factory.create(contentStub.inflate())
    }

    fun interface BindingFactory<VB : ViewBinding> {
        fun create(view: View): VB
    }
}
