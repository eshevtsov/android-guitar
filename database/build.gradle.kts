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
}

dependencies {
    room()
    androidTest()
}