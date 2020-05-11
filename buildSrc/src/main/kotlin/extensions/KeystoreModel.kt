package extensions

private const val PATH = "path"
private const val PASSWORD = "password"
private const val KEY_ALIAS = "keyAlias"
private const val KEY_PASSWORD = "keyPassword"

data class KeystoreModel(
    val path: String,
    val password: String,
    val keyAlias: String,
    val keyPassword: String
) {
    companion object
}

fun KeystoreModel.Companion.fromProperties(
    filePath: String
): KeystoreModel {
    val propertiesMap = readProperties(filePath)
    return propertiesMap.run {
        KeystoreModel(
            getValue(PATH),
            getValue(PASSWORD),
            getValue(KEY_ALIAS),
            getValue(KEY_PASSWORD)
        )
    }
}