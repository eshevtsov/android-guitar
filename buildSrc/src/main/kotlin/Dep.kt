import extensions.implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dep {
    const val kotlinJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"

    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val androidxCoreKtx = "androidx.core:core-ktx:${Version.androidxCoreKtx}"

    const val material = "com.google.android.material:material:${Version.material}"
}

fun DependencyHandler.appCompat() {
    implementation(Dep.appcompat)
    implementation(Dep.androidxCoreKtx)
}