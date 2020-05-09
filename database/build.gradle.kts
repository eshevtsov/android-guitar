plugins {
    kotlin("kapt")
}

android {
    defaultConfig {
        testInstrumentationRunner = Plugin.testRunner
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
                arg("room.incremental", "true")
                arg("room.expandProjection", "true")
            }
        }
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {
    room()
    androidTest()
    coroutines()
}