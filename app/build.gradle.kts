plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "moe.cachapa.android.mvvm.template"
    compileSdk = 33

    defaultConfig {
        applicationId = "moe.cachapa.android.mvvm.template"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "0.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.schemaLocation"] = "$projectDir/schemas"
                arguments["room.incremental"] = "true"
                arguments["room.expandProjection"] = "true"
            }
        }

    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
        create("stage") {
            // signingConfigs.getByName("debug")
            applicationIdSuffix = ".stage"
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true // Enables code shrinking for the release build type.
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

//Test dependencies
dependencies {

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // mockito test
    testImplementation("org.mockito:mockito-core:4.5.1")
    testImplementation("org.mockito:mockito-inline:4.5.1")
    testImplementation("com.linkedin.dexmaker:dexmaker-mockito:2.28.1")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")

    // Mock retrofit for test
    testImplementation("com.squareup.okhttp3:mockwebserver:5.0.0-alpha.7")

    // coroutine test library
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")

    // Koin Test Dependencies
    testImplementation("io.insert-koin:koin-test:3.1.0")
    implementation("io.insert-koin:koin-android:3.1.0")
    implementation("io.insert-koin:koin-androidx-workmanager:3.1.0")
}

//Core dependencies
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
    implementation("androidx.core:core-ktx:1.9.0")

    // AppCompat
    implementation("androidx.appcompat:appcompat:1.5.1")

    // LiveData - ViewModel
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    // Layout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Navigation Components
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.2")

    // Navigation Features
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.5.2")

    // ViewPager2
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("com.google.android.material:material:1.8.0-alpha01")

    // Paging
    implementation("androidx.paging:paging-runtime-ktx:3.1.1")

    // worker dependencies
    implementation("androidx.work:work-runtime-ktx:2.7.1")

    // Room
    implementation("androidx.room:room-ktx:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3")
}

//Third-party dependencies
dependencies {

    // OKHTTP
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.7")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.7")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    // Time library
    implementation("com.jakewharton.threetenabp:threetenabp:1.4.0")

    // Koin for Kotlin apps core
    implementation("io.insert-koin:koin-core:3.1.0")

    // model mapper
    implementation("org.modelmapper:modelmapper:3.1.0")

    // Chrome tabs
    implementation("androidx.browser:browser:1.4.0")

    // Glide (image)
    implementation("com.github.bumptech.glide:glide:4.13.2")
    kapt("com.github.bumptech.glide:compiler:4.13.2")

    //carousel recyclerview
    implementation("com.github.sparrow007:carouselrecyclerview:1.2.5")
}