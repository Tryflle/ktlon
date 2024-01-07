package me.tryfle.learning

import me.tryfle.learning.command.ResponseCommand
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.command.CommandBus

class Mod: ModInitializer {

    override fun preInit() {
        println("Hello Kotlin!")
        CommandBus.register(ResponseCommand())
    }
}