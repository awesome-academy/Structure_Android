plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    //Coroutine
    implementation(Deps.coroutines_core)
    implementation(Deps.coroutines_android)
    testImplementation(Deps.coroutines_test)
}
