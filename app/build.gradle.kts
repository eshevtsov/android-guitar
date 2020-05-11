import extensions.KeystoreModel
import extensions.fromProperties

val keystoreConfig = KeystoreModel.fromProperties(
    "${projectDir.path}\\signing_configs.properties"
)

plugins {
    id("androidx.navigation.safeargs.kotlin")
}

android {
    signingConfigs {
        create(App.RELEASE) {
            storeFile = file(keystoreConfig.path)
            storePassword = keystoreConfig.password
            keyAlias = keystoreConfig.keyAlias
            keyPassword = keystoreConfig.keyPassword
        }
    }
    defaultConfig {
        applicationId = App.applicationId
    }

    buildTypes {
        getByName(App.RELEASE) {
            signingConfig = signingConfigs.getByName(App.RELEASE)
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