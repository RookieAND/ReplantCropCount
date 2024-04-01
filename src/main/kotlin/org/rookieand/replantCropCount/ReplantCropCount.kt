package org.rookieand.replantCropCount

import net.kyori.adventure.text.Component
import org.bukkit.plugin.java.JavaPlugin

class ReplantCropCount: JavaPlugin() {
    override fun onEnable() {
        // setup
        logger.info("test")
        server.consoleSender.sendMessage(Component.text("plugin is enabled."))
    }

    override fun onDisable() {
        // setup
        logger.info("test")
    }
}