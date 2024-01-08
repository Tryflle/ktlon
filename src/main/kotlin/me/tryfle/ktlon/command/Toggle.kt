package me.tryfle.ktlon.command

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.listener.ClickListener
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.command.Command
import net.weavemc.loader.api.event.EventBus

class Toggle: Command("ktltoggle") {
    override fun handle(args: Array<out String>) {
        if (Data.instance.enabled) {
            Data.instance.enabled = false
            EventBus.unsubscribe(ClickListener())
        } else {
            Data.instance.enabled = true
            EventBus.subscribe(ClickListener())
        }
        Util.msg("Ktlon has been " + if (Data.instance.enabled) "enabled" else "disabled" + ".")
        Data.saveData(Data.instance)
    }
}