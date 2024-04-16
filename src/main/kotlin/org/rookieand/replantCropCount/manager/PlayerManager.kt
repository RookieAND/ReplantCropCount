package org.rookieand.replantCropCount.manager

import org.bukkit.entity.Player

class PlayerManager {

    private val playerCountMap = hashMapOf<Player, Int>()

    fun registerPlayer(player: Player) {
        playerCountMap[player] = 0
    }

    fun getReplantCount(player: Player): Int {
        val leftReplantAmount = playerCountMap[player]

        if (leftReplantAmount === null) {
            registerPlayer(player)
            return 0
        }

        return leftReplantAmount
    }

    fun addReplantCount(player: Player, count: Int) {
        val leftReplantAmount = playerCountMap[player]

        if (leftReplantAmount === null) {
            registerPlayer(player)
            return
        }

        playerCountMap[player] = leftReplantAmount + count
    }

    fun takeReplantCount(player: Player, count: Int) {
        val leftReplantAmount = playerCountMap[player]

        if (leftReplantAmount === null) {
            registerPlayer(player)
            return
        }

        playerCountMap[player] = leftReplantAmount - count
    }

    fun setReplantCount(player: Player, count: Int) {
        if (playerCountMap[player] === null) {
            registerPlayer(player)
            return
        }

        playerCountMap[player] = count
    }
}