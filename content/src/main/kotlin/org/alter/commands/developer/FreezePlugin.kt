package org.alter.commands.developer

import org.alter.api.ext.*
import org.alter.game.model.priv.Privilege
import org.alter.game.model.timer.FROZEN_TIMER
import org.alter.game.pluginnew.PluginEvent
import org.alter.game.pluginnew.event.impl.CommandEvent

class FreezePlugin : PluginEvent() {
    companion object {
        private const val TOGGLE_FREEZE_CYCLES = Int.MAX_VALUE
    }

    override fun init() {
        on<CommandEvent> {
            where {
                command.equals("freeze", ignoreCase = true) &&
                player.world.privileges.isEligible(player.privilege, Privilege.DEV_POWER)
            }
            then {
                val args = arguments ?: emptyArray()

                if (args.isEmpty()) {
                    player.message("Usage: ::freeze <target>")
                    return@then
                }

                val targetName = args[0]
                val target = player.world.getPlayerForName(targetName)

                if (target == null) {
                    player.message("Player '$targetName' not found.")
                    return@then
                }

                val isFrozen = target.timers.has(FROZEN_TIMER)

                if (isFrozen) {
                    target.timers.remove(FROZEN_TIMER)
                    player.message("Unfroze $targetName.")
                    target.message("You have been unfrozen by ${player.username}!")
                } else {
                    target.freeze(TOGGLE_FREEZE_CYCLES)
                    player.message("Froze $targetName.")
                    target.message("You have been frozen by ${player.username}!")
                }
            }
        }
    }
}
