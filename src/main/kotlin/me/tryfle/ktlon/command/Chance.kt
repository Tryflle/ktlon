package me.tryfle.ktlon.command

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.command.Command

class Chance: Command("ktlchance") {
    override fun handle(args: Array<out String>) {
        if (args[0].toInt() in 1..100) {
            Data.getData().chance = args[0].toInt()
            Util.sendMessage("Chance has been set to " + args[0] + "%.")
            Data.saveData(Data.getData())
        }
        else {
            Util.sendMessage("Please specify a chance from 1-100 in integer form.")
        }
    }
}