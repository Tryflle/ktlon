package me.tryfle.ktlon.command

import net.weavemc.loader.api.command.Command
import me.tryfle.ktlon.util.Util

class Help: Command("ktlon") {
    override fun handle(args: Array<out String>) {
        Util.msg("Ktlon - A double clicker for Weave written in Kotlin.")
        Util.msg("-------------------------------------------------")
        Util.msg("Commands:")
        Util.msg("/ktlon - Shows this message.")
        Util.msg("/ktlcps - Toggles 5 CPS check.")
        Util.msg("/ktltoggle - Toggles the mod.")
        Util.msg("/ktlbutton - Toggles between LMB and RMB modes.")
        Util.msg("/ktlchance (int) - Sets the chance of a double click.")
        Util.msg("-------------------------------------------------")
    }
}