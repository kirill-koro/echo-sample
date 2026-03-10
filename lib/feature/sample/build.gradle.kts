plugins {
    alias(libs.plugins.ru.tsu.echoSample.feature)
}

dependencies {
    implementation(projects.lib.utils)

    implementation(libs.moko.errors)
}