package me.tryfle.ktlon.command

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.command.Command

class CPS: Command("ktlcps") {
    override fun handle(args: Array<out String>) {
        Data.instance.fiveCps = !Data.instance.fiveCps
        Util.msg("5 CPS check is now " + if (Data.instance.fiveCps) "enabled" else "disabled" + ".")
        Data.saveData(Data.instance)
    }
}