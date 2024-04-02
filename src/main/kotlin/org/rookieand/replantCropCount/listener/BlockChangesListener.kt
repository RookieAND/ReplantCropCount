package org.rookieand.replantCropCount.listener

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.block.data.Ageable
import org.bukkit.block.data.BlockData
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.PlayerInventory

class BlockChangesListener : Listener {
    private val cropBlockSet =
        setOf<Material>(Material.WHEAT, Material.CARROT, Material.POTATO, Material.NETHER_WART, Material.BEETROOTS)
    private val cropSeedMap = mapOf<Material, Material>(
        Material.WHEAT to Material.WHEAT_SEEDS,
        Material.POTATO to Material.POTATOES,
        Material.CARROT to Material.CARROTS,
        Material.NETHER_WART to Material.NETHER_WART,
        Material.BEETROOTS to Material.BEETROOT_SEEDS
    )

    private fun isFullyGrown(blockData: BlockData): Boolean {
        return if (blockData is Ageable) blockData.maximumAge == blockData.age else false
    }

    private fun removeSeeds(cropType: Material, playerInventory: PlayerInventory): Boolean {
        if (!cropBlockSet.contains(cropType)) return false

        val needRemovedSeeds = cropSeedMap[cropType] ?: return false
        if (!playerInventory.contains(needRemovedSeeds)) return false

        val inventoryIterator = playerInventory.iterator()

        while (inventoryIterator.hasNext()) {
            val item = inventoryIterator.next()
            if (item.type === needRemovedSeeds) {
                val slotIndex = inventoryIterator.nextIndex()
                if (item.amount == 1) {
                    playerInventory.setItem(slotIndex, null)
                } else {
                    item.amount -= 1
                    playerInventory.setItem(slotIndex, item)
                }
                break
            }
        }

        return true
    }

    @EventHandler
    fun onBreakCropBlock(event: BlockBreakEvent) {
        val player = event.player
        if (player.gameMode !== GameMode.SURVIVAL) return

        val brokenBlockData = event.block.blockData
        if (isFullyGrown(brokenBlockData) and cropBlockSet.contains(brokenBlockData.material)) {
            val hasEnoughSeed = removeSeeds(brokenBlockData.material, player.inventory)
        }
    }
}
