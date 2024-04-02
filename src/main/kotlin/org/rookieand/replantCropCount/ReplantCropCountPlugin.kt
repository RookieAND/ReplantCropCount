package org.rookieand.replantCropCount

import net.kyori.adventure.text.Component
import org.bukkit.plugin.java.JavaPlugin

class ReplantCropCountPlugin : JavaPlugin() {
    override fun onEnable() {
        logger.info("test")
        server.consoleSender.sendMessage(Component.text("plugin is enabled."))
    }

    override fun onDisable() {
        logger.info("test")
    }
}