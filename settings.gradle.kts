rootProject.name = "GuitarAssistant"

include(
    ":app",

    ":core:uikit",
    ":core:feature",

    ":database",

    ":feature:home",
    ":feature:login",
    ":feature:artist",
    ":feature:album",
    ":feature:song"
)

