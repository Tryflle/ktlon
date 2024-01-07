package me.tryfle.ktlon

import me.tryfle.ktlon.command.*
import me.tryfle.ktlon.config.Data
import me.tryfle.ktlon.listener.ClickListener
import me.tryfle.ktlon.listener.WorldLoadListener
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.command.CommandBus
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.StartGameEvent

class Init: ModInitializer {
    override fun preInit() {
        println("[KtLon] Loading..")
        Data.loadData()
        EventBus.subscribe(StartGameEvent.Post::class.java) {
            init()
        }
    }
    private fun init() {
        CommandBus.register(Help())
        CommandBus.register(CPS())
        CommandBus.register(Button())
        CommandBus.register(Toggle())
        CommandBus.register(Chance())
        EventBus.subscribe(WorldLoadListener())
        if (Data.instance.enabled) EventBus.subscribe(ClickListener())
    }
}