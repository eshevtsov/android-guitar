import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Plugin.gradle)
        classpath(Plugin.googleServices)
        classpath(Plugin.navigationSafeArgs)
        classpath(kotlin("gradle-plugin", Version.kotlin))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    commonModuleConfiguration()
}

fun Project.commonModuleConfiguration() {
    /* if project has subprojects, than it is just a folder that shouldn't be configured - so return */
    if (!this.subprojects.isNullOrEmpty()) return

    when (name) {
        "app" -> apply(plugin = "com.android.application")
        else -> apply(plugin = "com.android.library")
    }
    apply(plugin = "kotlin-android")
    apply(plugin = "kotlin-android-extensions")

    configure<BaseExtension> {
        compileSdkVersion(App.compileSdk)
        defaultConfig {
            minSdkVersion(App.minSdk)
            targetSdkVersion(App.targetSdk)
            versionCode = App.versionCode
            versionName = App.versionName
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = App.kotlinJvmTarget
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}