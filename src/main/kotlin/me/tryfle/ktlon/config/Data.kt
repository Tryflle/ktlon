package me.tryfle.ktlon.config

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Data(
    var firstJoin: Boolean = true,
    var enabled: Boolean = false,
    var fiveCps: Boolean = false,
    var isLmb: Boolean = true,
    var chance: Int = 50
) {
    companion object {
        private val filePath: String = "${System.getProperty("user.home")}/.weave/ktlonconfig.json"
        private val file = File(filePath)
        val instance = loadData()

        fun saveData(data: Data) {
            file.parentFile.mkdirs()
            file.writeText(Json.encodeToString(data))
        }

        fun loadData(): Data = if (file.exists())
            Json.decodeFromString<Data>(file.readText())
        else Data()
    }
}