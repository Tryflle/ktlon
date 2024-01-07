package me.tryfle.ktlon.listener

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.Util
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.SubscribeEvent
import net.weavemc.loader.api.event.WorldEvent

class WorldLoadListener {
    @SubscribeEvent
    fun onWorldLoad(e: WorldEvent.Load) {
        if (Data.instance.firstJoin) {
            Data.instance.firstJoin = false
            Data.saveData(Data.instance)
            Util.msg("This is your first time using KtLon! Here's a list of commands.")
            Util.msg("---------------------------------------------------")
            Util.msg("Commands:")
            Util.msg("/ktlon - Shows this message.")
            Util.msg("/ktlcps - Toggles 5 CPS check.")
            Util.msg("/ktltoggle - Toggles the mod.")
            Util.msg("/ktlbutton - Toggles between LMB and RMB modes. (Default: LMB)")
            Util.msg("/ktlchance (int) - Sets the chance of a double click. (Default: 50)")
            Util.msg("---------------------------------------------------")
            Util.msg("Remember, you can run the command /ktlon at any time to see a list of commands.")
            Util.msg("By default, the mod is disabled. You can enable it by running /ktltoggle.")
        }
        EventBus.unsubscribe(this)
    }
}