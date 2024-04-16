package org.rookieand.replantCropCount.listener

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.rookieand.replantCropCount.manager.CropManager

class BlockChangesListener(
    private val cropManager: CropManager
) : Listener {

    @EventHandler
    fun onBreakCropBlock(event: BlockBreakEvent) {
        val player = event.player
        if (player.gameMode !== GameMode.SURVIVAL) return

        val blockData = event.block.blockData
        val blockMaterial = blockData.material
        val playerInventory = player.inventory

        if (!cropManager.isFullyGrownCrop(blockData) && cropManager.hasEnoughSeed(
                blockMaterial,
                playerInventory
            )
        ) return

        cropManager.takeSeed(
            blockData.material,
            playerInventory
        )

        cropManager.replantCrop(blockData.material, event.block.location)

    }
}
