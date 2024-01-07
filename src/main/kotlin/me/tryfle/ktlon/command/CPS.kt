package me.tryfle.ktlon.command

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.command.Command

class CPS : Command("ktlcps") {
    override fun handle(args: Array<out String>) {
        Data.dataInstance.fiveCps = !Data.dataInstance.fiveCps
        Util.sendMessage("5 CPS check is now " + if (Data.dataInstance.fiveCps) "enabled" else "disabled" + ".")
        Data.saveData(Data.dataInstance)
    }
}