package me.tryfle.ktlon.command

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.listener.ClickListener
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.command.Command

class Toggle: Command("ktltoggle") {
    override fun handle(args: Array<out String>) {
        if (Data.getData().enabled) {
            Data.getData().enabled = false
            ClickListener.disable()
        } else {
            Data.getData().enabled = true
            ClickListener.enable()
        }
        Util.sendMessage("Ktlon has been " + if (Data.getData().enabled) "enabled" else "disabled" + ".")
        Data.saveData(Data.getData())
    }
}