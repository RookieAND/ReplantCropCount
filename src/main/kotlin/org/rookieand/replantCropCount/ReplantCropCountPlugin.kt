package org.rookieand.replantCropCount

import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.rookieand.replantCropCount.listener.BlockChangesListener

class ReplantCropCountPlugin : JavaPlugin() {
    companion object {
        lateinit var instance: KoinApplication
    }

    override fun onEnable() {
        instance = initializeModule(this)
        server.pluginManager.registerEvents(instance.koin.get(BlockChangesListener::class), this)
    }

    override fun onDisable() {
        logger.info("test")
    }
}

fun initializeModule(plugin: JavaPlugin) = startKoin {
    modules(replantCropCountModule(plugin))
}