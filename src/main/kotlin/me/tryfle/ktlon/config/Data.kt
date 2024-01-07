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
        private val file = File("${System.getProperty("user.home")}/.weave/ktlonconfig.json")
        val dataInstance: Data by lazy { getData() }

        fun initializeData() {
            if (!file.exists()) {
                saveData(Data())
            }
        }

        fun saveData(data: Data) {
            file.parentFile.mkdirs()
            file.writeText(Json.encodeToString(data))
        }

        fun getData(): Data = Json.decodeFromString<Data>(file.readText())
    }
}