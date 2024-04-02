package org.rookieand.replantCropCount.listener

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.rookieand.replantCropCount.manager.CropManager

class BlockChangesListener : Listener {
    @EventHandler
    fun onBreakCropBlock(event: BlockBreakEvent) {
        val player = event.player
        if (player.gameMode !== GameMode.SURVIVAL) return

        val blockData = event.block.blockData
        if (CropManager.isCropBlock(blockData) && CropManager.isFullyGrown(blockData)) {
            val hasEnoughSeed = CropManager.takeSeed(blockData.material, player.inventory)
        }
    }
}
