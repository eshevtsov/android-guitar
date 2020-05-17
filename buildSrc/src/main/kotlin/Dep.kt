import extensions.*
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dep {
    const val kotlinJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"

    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val androidxCoreKtx = "androidx.core:core-ktx:${Version.androidxCoreKtx}"

    const val material = "com.google.android.material:material:${Version.material}"

    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val roomTesting = "androidx.room:room-testing:${Version.room}"

    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragment}"
    const val fragmentTesting = "androidx.fragment:fragment-testing:${Version.fragment}"

    const val activityKtx = "androidx.activity:activity-ktx:${Version.activity}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val viewmodelSavedstate = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.lifecycle}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Version.lifecycle}"
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Version.lifecycle}"
    const val coreTesting = "androidx.arch.core:core-testing:${Version.lifecycleArch}"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val navigationTesting = "androidx.navigation:navigation-testing:${Version.navigation}"

    const val koinScope = "org.koin:koin-androidx-scope:${Version.koin}"
    const val koinViewmodel =  "org.koin:koin-androidx-viewmodel:${Version.koin}"
    const val koinFragment =  "org.koin:koin-androidx-fragment:${Version.koin}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"

    const val googleAuth = "com.google.android.gms:play-services-auth:${Version.googleAuth}"

    const val testRunner = "androidx.test:runner:${Version.testRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    const val jUnit = "androidx.test.ext:junit:${Version.jUnit}"
    const val truthExt = "androidx.test.ext:truth:${Version.truthExt}"
    const val robolectric = "org.robolectric:robolectric:${Version.robolectric}"
    const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Version.kotlin}"
    const val truth = "com.google.truth:truth:${Version.truth}"
    const val mockkAndroid =  "io.mockk:mockk-android:${Version.mockk}"
    const val mockk =  "io.mockk:mockk:${Version.mockk}"
}

fun DependencyHandler.coroutines() {
    implementation(Dep.coroutines)
}

fun DependencyHandler.koin() {
    implementation(Dep.koinScope)
    implementation(Dep.koinFragment)
    implementation(Dep.koinViewmodel)
}

fun DependencyHandler.navigation() {
    implementation(Dep.navigationFragment)
    implementation(Dep.navigationUi)
    androidTestImplementation(Dep.navigationTesting)
}

fun DependencyHandler.lifecycle() {
    implementation(Dep.viewmodel)
    implementation(Dep.viewmodelSavedstate)
    implementation(Dep.livedata)
    implementation(Dep.lifecycleRuntime)
    implementation(Dep.lifecycleService)
    implementation(Dep.lifecycleProcess)
    testImplementation(Dep.coreTesting)
    androidTestImplementation(Dep.coreTesting)
}

fun DependencyHandler.fragment() {
    implementation(Dep.fragmentKtx)
    androidTestImplementation(Dep.fragmentTesting)
}

fun DependencyHandler.activity() {
    implementation(Dep.activityKtx)
}

fun DependencyHandler.appCompat() {
    implementation(Dep.appcompat)
    implementation(Dep.androidxCoreKtx)
}

fun DependencyHandler.room() {
    implementation(Dep.roomRuntime)
    kapt(Dep.roomCompiler)
    implementation(Dep.roomKtx)
    androidTestImplementation(Dep.roomTesting)
    testImplementation(Dep.roomTesting)
}

fun DependencyHandler.test() {
    testImplementation(Dep.coroutinesTest)
    testImplementation(Dep.jUnit)
    testImplementation(Dep.kotlinJUnit)
    testImplementation(Dep.truth)
    testImplementation(Dep.truthExt)
    testImplementation(Dep.mockk)
}

fun DependencyHandler.androidTest() {
    androidTestImplementation(Dep.coroutinesTest)
    androidTestImplementation(Dep.testRunner)
    androidTestImplementation(Dep.espressoCore)
    androidTestImplementation(Dep.jUnit)
    androidTestImplementation(Dep.kotlinJUnit)
    androidTestImplementation(Dep.truth)
    androidTestImplementation(Dep.truthExt)
    androidTestImplementation(Dep.mockkAndroid)
}