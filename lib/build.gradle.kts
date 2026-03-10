plugins {
    alias(libs.plugins.ru.tsu.echoSample.lib)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android.namespace = "ru.tsu.echoSample.lib"

val projectModules = listOf(
    projects.lib.feature.topic,
    projects.lib.utils,
)

dependencies {
    projectModules.forEach(::api)
    api(projects.i18n)

    api(libs.bundles.network)

    implementation(libs.dagger)
    api(libs.dagger.android)
    api(libs.dagger.android.support)
    ksp(libs.dagger.compiler)
    ksp(libs.dagger.android.processor)

    api(libs.moko.errors)
    api(libs.moko.units)
    implementation(libs.moko.network.errors)
    api(libs.multiplatformSettings)
}