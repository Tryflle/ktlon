package me.tryfle.ktlon.command

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.command.Command

class Chance: Command("ktlchance") {
    override fun handle(args: Array<out String>) {
        if (args.isEmpty()) {
            Util.msg("Chance is currently set to " + Data.instance.chance + "%.")
        } else if (args[0].toInt() in 0..100) {
            Data.instance.chance = args[0].toInt()
            Util.msg("Chance has been set to " + args[0] + "%.")
            Data.saveData(Data.instance) } else {
            Util.msg("Please specify a chance from 1-100 in integer form.")
        }
    }
}