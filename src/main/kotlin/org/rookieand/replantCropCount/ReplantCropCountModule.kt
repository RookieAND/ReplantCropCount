package org.rookieand.replantCropCount

import org.bukkit.plugin.java.JavaPlugin
import org.koin.dsl.module
import org.rookieand.replantCropCount.listener.BlockChangesListener
import org.rookieand.replantCropCount.manager.CropManager
import org.rookieand.replantCropCount.manager.PlayerManager
import org.bukkit.plugin.Plugin as BukkitPlugin

fun replantCropCountModule(plugin: JavaPlugin) = module {
    single<BukkitPlugin> { plugin }

    single<CropManager> { CropManager(plugin) }
    single<PlayerManager> { PlayerManager() }

    single<BlockChangesListener> { BlockChangesListener(get()) }
}
