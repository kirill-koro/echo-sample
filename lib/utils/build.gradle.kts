plugins {
    alias(libs.plugins.ru.tsu.echoSample.lib)
    alias(libs.plugins.google.devtools.ksp)
}

android.namespace = "ru.tsu.echoSample.lib.utils"

dependencies {
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    implementation(libs.moko.resources)
    implementation(libs.moko.fields.flow)
}