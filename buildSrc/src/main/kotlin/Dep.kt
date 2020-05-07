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
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    const val testRunner = "androidx.test:runner:${Version.testRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    const val jUnit = "androidx.test.ext:junit:${Version.jUnit}"
    const val robolectric = "org.robolectric:robolectric:${Version.robolectric}"
    const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Version.kotlin}"
    const val truth = "com.google.truth:truth:${Version.truth}"
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

fun DependencyHandler.androidTest() {
    androidTestImplementation(Dep.coroutinesTest)
    androidTestImplementation(Dep.testRunner)
    androidTestImplementation(Dep.espressoCore)
    androidTestImplementation(Dep.jUnit)
    androidTestImplementation(Dep.kotlinJUnit)
    androidTestImplementation(Dep.truth)
}