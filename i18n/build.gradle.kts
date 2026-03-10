plugins {
    alias(libs.plugins.ru.tsu.echoSample.multiplatform.lib)
    alias(libs.plugins.icerock.mobile.multiplatformResources)
}

android.namespace = "ru.tsu.echoSample.i18n"

multiplatformResources {
    resourcesPackage = "ru.tsu.echoSample.i18n"
    resourcesClassName = "MR"
}