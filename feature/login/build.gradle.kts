dependencies {
    implementation(project(Module.database))
    implementation(project(Module.coreFeature))

    coroutines()
    fragment()
    activity()
    lifecycle()
    implementation(Dep.constraintLayout)
    implementation(Dep.googleAuth)
}