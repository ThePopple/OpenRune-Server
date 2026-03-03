package org.alter.commands.developer

import org.alter.api.ext.message
import org.alter.game.model.priv.Privilege
import org.alter.game.model.timer.FROZEN_TIMER
import org.alter.game.model.timer.STUN_TIMER
import org.alter.game.pluginnew.PluginEvent
import org.alter.game.pluginnew.event.impl.CommandEvent

class TimersDebugPlugin : PluginEvent() {

    override fun init() {
        on<CommandEvent> {
            where {
                (command.equals("timers", ignoreCase = true) ||
                    command.equals("debugtimers", ignoreCase = true)) &&
                    player.world.privileges.isEligible(player.privilege, Privilege.DEV_POWER)
            }
            then {
                val args = arguments ?: emptyArray()
                val target = if (args.isNotEmpty()) player.world.getPlayerForName(args[0]) else player

                if (target == null) {
                    player.message("Player '${args[0]}' not found.")
                    return@then
                }

                val timerMap = target.timers.getTimers()
                val frozen = timerMap[FROZEN_TIMER] ?: 0
                val stunned = timerMap[STUN_TIMER] ?: 0
                val activeCount = timerMap.count { it.value > 0 }

                player.message("Timers for ${target.username}: frozen=$frozen, stunned=$stunned, active=$activeCount")
            }
        }
    }
}

