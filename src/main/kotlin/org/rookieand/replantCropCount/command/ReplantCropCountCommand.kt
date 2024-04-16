package org.rookieand.replantCropCount.command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.rookieand.replantCropCount.manager.PlayerManager

class ReplantCropCountCommand(private val playerManager: PlayerManager) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) {
            sender.sendMessage("플레이어만 사용 가능한 커멘드입니다.")
            return false
        }

        val player = sender.player
        if (player === null) return false

        val firstArgs = args.elementAt(0)
        val secondArgs = args.elementAt(1)

        when (firstArgs) {
            "add" -> {
                val targetPlayer = Bukkit.getOfflinePlayer(secondArgs)
            }
        }



        return true
    }
}