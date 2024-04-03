package org.rookieand.replantCropCount

import org.bukkit.plugin.java.JavaPlugin
import org.rookieand.replantCropCount.listener.BlockChangesListener

class ReplantCropCountPlugin : JavaPlugin() {

    companion object {
        lateinit var instance: JavaPlugin
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(BlockChangesListener(), this)
    }

    override fun onDisable() {
        logger.info("test")
    }
}