android {
    defaultConfig {
        testInstrumentationRunner = Plugin.testRunner
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {
    api(project(Module.coreUi))

    api(Dep.kotlinJdk)
    lifecycle()
    appCompat()
    test()
    androidTest()
}