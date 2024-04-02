package org.rookieand.replantCropCount.manager

import org.bukkit.Material
import org.bukkit.block.data.Ageable
import org.bukkit.block.data.BlockData
import org.bukkit.inventory.PlayerInventory

object CropManager {
    private val cropBlockSet =
        setOf<Material>(Material.WHEAT, Material.CARROT, Material.POTATO, Material.NETHER_WART, Material.BEETROOTS)
    private val cropSeedMap = mapOf<Material, Material>(
        Material.WHEAT to Material.WHEAT_SEEDS,
        Material.POTATO to Material.POTATOES,
        Material.CARROT to Material.CARROTS,
        Material.NETHER_WART to Material.NETHER_WART,
        Material.BEETROOTS to Material.BEETROOT_SEEDS
    )

    fun isFullyGrown(blockData: BlockData): Boolean {
        if (blockData !is Ageable) return false
        return blockData.maximumAge == blockData.age
    }

    fun isCropBlock(blockData: BlockData): Boolean {
        return cropBlockSet.contains(blockData.material)
    }

    fun takeSeed(cropType: Material, playerInventory: PlayerInventory): Boolean {
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
}