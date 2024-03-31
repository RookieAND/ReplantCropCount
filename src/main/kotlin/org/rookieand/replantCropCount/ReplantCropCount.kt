package org.rookieand

import org.bukkit.plugin.java.JavaPlugin;

class ReplantCropCount: JavaPlugin() {
    override fun onEnable() {
        // setup
        saveDefaultConfig();
        logger.info("test");
    }

    override fun onDisable() {
        // setup
        saveConfig();
    }

}