import com.android.build.gradle.BaseExtension
import extensions.KeystoreModel
import extensions.fromProperties

val releaseKeystore = KeystoreModel.fromProperties("${projectDir.path}\\release_configs.properties")
val debugKeystore = KeystoreModel.fromProperties("${projectDir.path}\\debug_configs.properties")

plugins {
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
    kotlin("kapt")
}

android {
    defaultConfig {
        applicationId = App.applicationId
    }
    createSigningConfigs(
        Signing.DEBUG to debugKeystore,
        Signing.RELEASE to releaseKeystore
    )
    buildTypes {
        getByName(App.DEBUG) {
            signingConfig = signingConfigs.getByName(Signing.DEBUG)
        }
        getByName(App.RELEASE) {
            signingConfig = signingConfigs.getByName(Signing.RELEASE)
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(Module.database))
    implementation(project(Module.coreFeature))
    implementation(project(Module.featureHome))
    implementation(project(Module.featureLogin))
    implementation(project(Module.featureArtist))

    room()
    appCompat()
    navigation()
    fragment()
    koin()
    implementation(Dep.googleAuth)

    test()
    androidTest()
}

fun Project.createSigningConfigs(
    vararg keystoreList: Pair<String, KeystoreModel>
) =
    keystoreList.forEach { (name: String, model: KeystoreModel) ->
        configure<BaseExtension> {
            signingConfigs {
                create(name) {
                    storeFile = file(model.path)
                    storePassword = model.password
                    keyAlias = model.keyAlias
                    keyPassword = model.keyPassword
                }
            }
        }
    }