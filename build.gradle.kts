buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Plugin.gradle)
        classpath(kotlin("gradle-plugin", Version.kotlin))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}