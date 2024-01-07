package me.tryfle.ktlon.util

import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

object Util {
    fun msg(msg: String) {
        if (Minecraft.getMinecraft().thePlayer == null) return
        Minecraft.getMinecraft().thePlayer.addChatMessage(ChatComponentText("[" +  EnumChatFormatting.DARK_PURPLE + "K" + EnumChatFormatting.RESET + "] " + msg))
    }

    fun randInt(min: Int, max: Int): Int {
        return (Math.random() * (max - min + 1) + min).toInt()
    }
}