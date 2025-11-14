package org.alter.skills.thieving

import dev.openrune.ServerCacheManager
import org.alter.api.Skills
import org.alter.api.ext.message
import org.alter.game.model.entity.Npc
import org.alter.game.model.entity.Player
import org.alter.game.pluginnew.PluginEvent
import org.alter.game.pluginnew.event.impl.NpcClickEvent

class PickpocketingEvents : PluginEvent() {

    companion object {

    }

    override fun init() {
        val allNpcs = ServerCacheManager.getNpcs().filter { it.value.actions.contains("Pickpocket") }

        allNpcs.forEach { (_, npcDef) ->
            if (!npcDef.actions.contains("Pickpocket")) return@forEach
            if (npcDef.category != -1) {
                val data = Pickpocketing.byCategory(npcDef.category)!!

                on<NpcClickEvent> {
                    where { npc.id == npcDef.id && optionName.equals("pickpocket", ignoreCase = true) }
                    then {
                        if (!canPickpocket(player, npc, data))
                        pickpocketNpc(player, npc, data)
                    }
                }
            } else {
                // TODO: Implement NPC id list handling for pickpocketing when no category is defined
            }

        }
    }


    private fun canPickpocket(player: Player, npc: Npc, data: Pickpocketing.PickpocketNPCData): Boolean {
        val lvl = player.getSkills().getCurrentLevel(Skills.THIEVING)

        return arrayOf(
            lvl > data.level,
            player.isAlive(),
            !player.isLocked(),
            !player.inventory.isFull,
            npc.isAlive(),
            npc.isActive()

        ).all { it }
    }

    private fun pickpocketNpc(player: Player, npc: Npc, data: Pickpocketing.PickpocketNPCData) {
        player.message("You pick the ${npc.def.name}'s pocket.")
    }
}
