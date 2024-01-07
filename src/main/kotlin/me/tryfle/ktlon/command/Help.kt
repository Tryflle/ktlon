package me.tryfle.ktlon.command

import net.weavemc.loader.api.command.Command
import me.tryfle.ktlon.util.Util

class Help: Command("ktlon") {
    override fun handle(args: Array<out String>) {
        Util.sendMessage("Ktlon - A double clicker for Weave written in Kotlin.")
        Util.sendMessage("---------------------------------------------------")
        Util.sendMessage("Commands:")
        Util.sendMessage("/ktlon - Shows this message.")
        Util.sendMessage("/ktlcps - Toggles 5 CPS check.")
        Util.sendMessage("/ktltoggle - Toggles the mod.")
        Util.sendMessage("/ktlbutton - Toggles between LMB and RMB modes.")
        Util.sendMessage("/ktlchance (int) - Sets the chance of a double click.")
        Util.sendMessage("---------------------------------------------------")
    }
}