plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.android.hsicen.hiltsample"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = TestDeps.runner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
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

dependencies {
    testImplementation(TestDeps.junit)
    androidTestImplementation(TestDeps.junitExt)
    androidTestImplementation(TestDeps.espresso)

    implementation(fileTree(Deps.fileMap))
    implementation(Deps.kotlinStb)

    implementation(Deps.appCompat)
    implementation(Deps.ktx)
    implementation(Deps.constrainLayout)

    //Hilt 依赖
    kapt(Deps.hiltCompiler)
    kapt(Deps.hiltAndroidCompiler)
    implementation(Deps.hiltAndroid)

    //ButterKnife
    implementation(Deps.butterknife)
}
