plugins {
    alias(libs.plugins.ru.tsu.echoSample.feature)
}

dependencies {
    implementation(projects.lib.utils)
    implementation(projects.i18n)

    implementation(libs.moko.errors)
    implementation(libs.moko.fields.flow)
}