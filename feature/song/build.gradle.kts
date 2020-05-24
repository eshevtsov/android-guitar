dependencies {
    implementation(project(Module.database))
    implementation(project(Module.coreFeature))
    implementation(project(Module.featureLogin))

    coroutines()
    fragment()
    lifecycle()
    implementation(Dep.constraintLayout)
    implementation(Dep.coil)
}