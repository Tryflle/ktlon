package me.tryfle.ktlon.listener

import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.util.TimerUtil
import me.tryfle.ktlon.util.Util
import net.minecraft.client.Minecraft
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.MouseEvent
import net.weavemc.loader.api.event.SubscribeEvent
import net.weavemc.loader.api.event.TickEvent

import java.awt.*

class ClickListener {

    private var cps: Int = 0
    private var t: TimerUtil = TimerUtil()
    private var r = Robot()
    private var shouldClick: Boolean = false

    private fun getEventButton(): Int {
        return if (Data.getData().isLmb) 1 else 2
    }

    private fun robotGetButton(): Int {
        return if (Data.getData().isLmb) 16 else 4
    }

    private fun rClick() {
        val sleepTime: Long = Util.randInt(30, 60).toLong()
        Thread {
            shouldClick = if (shouldClick) {
                r.mouseRelease(robotGetButton())
                r.mousePress(robotGetButton())
                Thread.sleep(sleepTime)
                r.mouseRelease(robotGetButton())
                false
            } else true
        }
        println("[K-Debug] Sleeping for $sleepTime")
    }

    @SubscribeEvent
    fun onClick(e: MouseEvent) {
        if (Minecraft.getMinecraft().thePlayer != null && e.button == getEventButton()) {
            cps++
            if (shouldClick) {
                val ch: Double = Math.random() * 100
                if (ch.toInt() >= Data.getData().chance) {
                    println("[K-Debug] Chance missed, value $ch")
                    return
                }
            }
            if (Data.getData().fiveCps && cps < 5) return
            rClick()
        }
    }

    @SubscribeEvent
    fun onTick(e: TickEvent) {
        if (t.hasPassed(1000)) {
            cps = 0
            t.reset()
        }
    }

    companion object {
        fun disable() {
            EventBus.unsubscribe(this)
            println("[K-Debug] Disabled ClickListener")
        }

        fun enable() {
            EventBus.subscribe(this)
            println("[K-Debug] Enabled ClickListener")
        }
    }
}