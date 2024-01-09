package me.tryfle.ktlon.listener

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.TimerUtil
import me.tryfle.ktlon.util.Util
import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.weavemc.loader.api.event.MouseEvent
import net.weavemc.loader.api.event.SubscribeEvent
import net.weavemc.loader.api.event.TickEvent

class ClickListener {

    private var cps: Int = 0
    private var t: TimerUtil = TimerUtil()
    private var shouldClick: Boolean = false

    private fun getEventButton(): Int {
        return if (Data.loadData().isLmb) 0 else 1
    }

    private fun getButton(): Int {
        return if (Data.loadData().isLmb) Minecraft.getMinecraft().gameSettings.keyBindAttack.keyCode
        else Minecraft.getMinecraft().gameSettings.keyBindUseItem.keyCode
    }

    private suspend fun rClick() {
        val sleepTime: Long = Util.randInt(30, 60).toLong()
        if (shouldClick) {
            delay(sleepTime)
            KeyBinding.setKeyBindState(getButton(), false)
            KeyBinding.onTick(getButton())
            delay(sleepTime + Util.randInt(-10, 10).toLong())
            KeyBinding.setKeyBindState(getButton(), true)
            KeyBinding.onTick(getButton())
            KeyBinding.setKeyBindState(getButton(), false)
            KeyBinding.onTick(getButton())
            shouldClick = false
        } else shouldClick = true
    }

    @SubscribeEvent
    fun onClick(e: MouseEvent) {
        if (Data.instance.enabled && Minecraft.getMinecraft().thePlayer != null && e.button == getEventButton()) {
            cps++
            if (shouldClick) {
                val ch: Double = Math.random() * 100;
                if (ch.toInt() >= Data.instance.chance) {
                    return
                }
            }
            if (Data.instance.fiveCps && cps < 7) return //for some reason 5 cps is 7 cps lol??
            GlobalScope.launch { rClick() }
        }
    }

    @SubscribeEvent
    fun onTick(e: TickEvent) {
        if (t.hasPassed(1000)) {
            cps = 0
            t.reset()
        }
    }
}