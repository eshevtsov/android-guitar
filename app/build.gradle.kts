plugins {
    id("androidx.navigation.safeargs.kotlin")
}

android {
    defaultConfig {
        applicationId = App.applicationId
    }

    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(Module.coreFeature))
    implementation(project(Module.featureHome))
    implementation(project(Module.featureLogin))

    appCompat()
    navigation()
    fragment()
    koin()
}