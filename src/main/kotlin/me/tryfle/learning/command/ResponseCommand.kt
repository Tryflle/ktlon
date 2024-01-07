package me.tryfle.learning.command

import net.minecraft.client.Minecraft
import net.weavemc.loader.api.command.Command
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

class ResponseCommand: Command("responsecommand") {
    override fun handle(args: Array<out String>) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(ChatComponentText(EnumChatFormatting.GREEN.toString() + "Hello Kotlin!"))
    }
}