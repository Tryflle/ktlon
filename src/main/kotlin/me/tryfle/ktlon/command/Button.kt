package me.tryfle.ktlon.command

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.command.Command

class Button: Command("ktlbutton") {
    override fun handle(args: Array<out String>) {
        Data.instance.isLmb = !Data.instance.isLmb
        Util.msg("Button has been set to " + if (Data.instance.isLmb) "LMB" else "RMB" + ".")
        Data.saveData(Data.instance)
    }
}