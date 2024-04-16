package org.rookieand.replantCropCount.manager

import org.bukkit.entity.Player

class PlayerManager {

    private val playerCountMap = hashMapOf<Player, Int>()

    private fun registerPlayer(player: Player): Int {
        playerCountMap[player] = 0
        return 0
    }

    fun getReplantCount(player: Player): Int {
        val leftReplantAmount = playerCountMap[player] ?: registerPlayer(player)
        return leftReplantAmount
    }

    fun addReplantCount(player: Player, count: Int) {
        val leftReplantAmount = playerCountMap[player] ?: registerPlayer(player)
        playerCountMap[player] = leftReplantAmount + count
    }

    fun takeReplantCount(player: Player, count: Int) {
        val leftReplantAmount = playerCountMap[player] ?: registerPlayer(player)
        playerCountMap[player] = leftReplantAmount - count
    }

    fun setReplantCount(player: Player, count: Int) {
        if (playerCountMap[player] === null) {
            registerPlayer(player)
        }

        playerCountMap[player] = count
    }
}