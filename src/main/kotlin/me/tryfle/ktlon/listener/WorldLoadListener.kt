package me.tryfle.ktlon.listener

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.SubscribeEvent
import net.weavemc.loader.api.event.WorldEvent

class WorldLoadListener {
    @SubscribeEvent
    fun onWorldLoad(e: WorldEvent.Load) {
        Data.dataInstance.apply {
            if (firstJoin) {
                firstJoin = false
                Data.saveData(this)
                Util.sendMessage("This is your first time using KtLon! Here's a list of commands.")
                Util.sendMessage("---------------------------------------------------")
                Util.sendMessage("Commands:")
                Util.sendMessage("/ktlon - Shows this message.")
                Util.sendMessage("/ktlcps - Toggles 5 CPS check.")
                Util.sendMessage("/ktltoggle - Toggles the mod.")
                Util.sendMessage("/ktlbutton - Toggles between LMB and RMB modes. (Default: LMB)")
                Util.sendMessage("/ktlchance (int) - Sets the chance of a double click. (Default: 50)")
                Util.sendMessage("---------------------------------------------------")
                Util.sendMessage("Remember, you can run the command /ktlon at any time to see a list of commands.")
                Util.sendMessage("By default, the mod is disabled. You can enable it by running /ktltoggle.")
            }
        }
        EventBus.unsubscribe(this)
    }
}