package me.tryfle.ktlon.command

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.command.Command

class Button: Command("ktlbutton") {
    override fun handle(args: Array<out String>) {
        Data.getData().isLmb = !Data.getData().isLmb
        Util.sendMessage("Button has been set to " + if (Data.getData().isLmb) "LMB" else "RMB" + ".")
        Data.saveData(Data.getData())
    }
}