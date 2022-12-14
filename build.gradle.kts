// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.3.0" apply false
    id("com.android.library") version "7.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        //classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.2")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.2.0")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}