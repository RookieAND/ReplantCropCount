package org.rookieand.replantCropCount.listener

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.block.data.Ageable
import org.bukkit.block.data.BlockData
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class BlockChangesListener : Listener {
    private val cropBlockSet = setOf<Material>(Material.WHEAT, Material.CARROT, Material.POTATO, Material.NETHER_WART, Material.BEETROOTS)
    private val cropSeedMap = mapOf<Material, Material>(Material.WHEAT to Material.WHEAT_SEEDS, Material.POTATO to Material.POTATOES, Material.CARROT to Material.CARROTS, Material.NETHER_WART to Material.NETHER_WART, Material.BEETROOTS to Material.BEETROOT_SEEDS);
    private fun isFullyGrown (blockData: BlockData): Boolean {
        return if (blockData is Ageable) blockData.maximumAge == blockData.age else false;
    }
    @EventHandler
    fun onBreakCropBlock(event: BlockBreakEvent) {
        val player = event.player
        if (player.gameMode !== GameMode.SURVIVAL) return;

        val brokenBlockData = event.block.blockData;
        if (isFullyGrown(brokenBlockData) and cropBlockSet.contains(brokenBlockData.material)) {
           
        }
    }
}