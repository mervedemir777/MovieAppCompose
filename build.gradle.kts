plugins {
    id("com.android.application") version "8.5.2" apply false
    id("com.android.library") version "8.5.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.20" apply false
    id("com.google.dagger.hilt.android") version "2.56" apply false
}

buildscript {
    // Compose UI version can still be defined as an extra property
    extra.set("compose_ui_version", "1.6.10")
}

