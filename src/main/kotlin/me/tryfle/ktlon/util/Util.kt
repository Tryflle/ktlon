package me.tryfle.ktlon.util

import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import kotlin.random.Random

object Util {
    fun sendMessage(message: String) =
        Minecraft.getMinecraft().thePlayer?.addChatMessage(
            ChatComponentText("[${EnumChatFormatting.DARK_PURPLE}K${EnumChatFormatting.RESET}] $message")
        )

    fun randInt(min: Int, max: Int): Int = Random.nextInt(min, max + 1)
}
