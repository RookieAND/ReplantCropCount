package kr.argonaut.replantCropCount

import kr.argonaut.replantCropCount.listener.BlockChangesListener
import org.bukkit.plugin.java.JavaPlugin

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