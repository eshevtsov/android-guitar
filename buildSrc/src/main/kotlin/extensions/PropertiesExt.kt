package extensions

import java.io.FileInputStream
import java.util.*

fun readProperties(filePath: String): Map<String, String> {
    val properties = Properties()
        .apply { load(FileInputStream(filePath)) }
    return properties.stringPropertyNames()
        .map { it to properties.getProperty(it) }
        .toMap()
}