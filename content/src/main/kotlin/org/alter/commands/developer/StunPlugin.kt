package org.alter.commands.developer

import org.alter.api.ext.*
import org.alter.game.model.priv.Privilege
import org.alter.game.model.timer.STUN_TIMER
import org.alter.game.pluginnew.PluginEvent
import org.alter.game.pluginnew.event.impl.CommandEvent

class StunPlugin : PluginEvent() {
    companion object {
        private const val DEFAULT_STUN_CYCLES = 6
    }

    override fun init() {
        on<CommandEvent> {
            where {
                command.equals("stun", ignoreCase = true) &&
                player.world.privileges.isEligible(player.privilege, Privilege.DEV_POWER)
            }
            then {
                val args = arguments ?: emptyArray()

                if (args.isEmpty()) {
                    player.message("Usage: ::stun <target> [cycles]")
                    return@then
                }

                val targetName = args[0]
                val target = player.world.getPlayerForName(targetName)

                if (target == null) {
                    player.message("Player '$targetName' not found.")
                    return@then
                }

                val cycles = if (args.size >= 2) {
                    args[1].toIntOrNull()
                } else {
                    DEFAULT_STUN_CYCLES
                }

                if (cycles == null || cycles <= 0) {
                    player.message("Cycles must be a positive integer.")
                    return@then
                }

                if (target.timers.has(STUN_TIMER)) {
                    target.timers[STUN_TIMER] = cycles
                    player.message("Refreshed stun on $targetName for $cycles cycles.")
                } else {
                    target.stun(cycles)
                    player.message("Stunned $targetName for $cycles cycles.")
                    target.message("You have been stunned by ${player.username}!")
                }
            }
        }
    }
}