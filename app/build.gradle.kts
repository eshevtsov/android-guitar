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
    implementation(project(Module.coreUi))
    implementation(project(Module.featureSplash))

    implementation(Dep.kotlinJdk)
    appCompat()
}