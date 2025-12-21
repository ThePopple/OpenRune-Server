package org.alter.skills.thieving

import dev.openrune.ServerCacheManager
import io.github.oshai.kotlinlogging.KotlinLogging
import org.alter.api.Skills
import org.alter.api.ext.hit
import org.alter.api.ext.message
import org.alter.api.success
import org.alter.game.model.entity.Npc
import org.alter.game.model.entity.Player
import org.alter.game.pluginnew.PluginEvent
import org.alter.game.pluginnew.event.impl.NpcClickEvent
import org.alter.skills.thieving.PickPocketingDefinitions.npcDataByCategory
import org.alter.skills.thieving.PickPocketingDefinitions.npcDataById
import org.generated.tables.thieving.SkillThievingPickpocketingRow

class PickpocketingEvents : PluginEvent() {

    private val logger = KotlinLogging.logger {}

    override fun init() {
        val allNpcs = ServerCacheManager.getNpcs().filter { it.value.actions.contains("Pickpocket") }

        allNpcs.forEach { (_, npcDef) ->
            if (!npcDef.actions.contains("Pickpocket")) return@forEach
            if (npcDef.category != -1) {
                val data = npcDataByCategory(npcDef.category)
                if (data == null) {
                    logger.warn { "No pickpocketing data found for NPC category ${npcDef.category} (NPC id:name - ${npcDef.name}:${npcDef.id})" }
                    return@forEach
                }

                on<NpcClickEvent> {
                    where { npc.id == npcDef.id && optionName.equals("pickpocket", ignoreCase = true) }
                    then {
                        player.queue {
                            pickpocketNpc(player, npc, data)
                        }
                    }
                }
            } else {
                val data = npcDataById(npcDef.id)
                if (data == null) {
                    logger.warn { "No pickpocketing data found for NPC id:name - ${npcDef.name}:${npcDef.id}" }
                    return@forEach
                }

                on<NpcClickEvent> {
                    where { npc.id == npcDef.id && optionName.equals("pickpocket", ignoreCase = true) }
                    then {
                        player.queue {
                            pickpocketNpc(player, npc, data)
                        }
                    }
                }

                // TODO: Implement NPC id list handling for pickpocketing when no category is defined
            }

        }
    }


    private fun canPickpocket(player: Player, npc: Npc, data: SkillThievingPickpocketingRow): String? {
        if (player.getSkills().getCurrentLevel(Skills.THIEVING) < data.level) {
            return "You need a thieving level of ${data.level} to pickpocket this NPC."
        }

        if (player.inventory.isFull) {
            return "You don't have enough inventory space to pickpocket."
        }

        if (!player.isAlive()) {
            return "You can't pickpocket while dead."
        }

        if (player.isLocked()) {
            return "You can't pickpocket right now."
        }

        if (!npc.isAlive()) {
            return "You can't pickpocket a dead NPC."
        }
        if (!npc.isActive()) {
            return "You can't pickpocket an inactive NPC."
        }

        return null
    }

    private fun pickpocketNpc(player: Player, npc: Npc, data: SkillThievingPickpocketingRow) {
        canPickpocket(player, npc, data)?.let {
            player.message(it)
            return
        }

        val lvl = player.getSkills().getCurrentLevel(Skills.THIEVING)
        val success = success(data.lowChance, data.highChance, lvl)

        player.message("You attempt to pick the ${npc.def.name}'s pocket.")
        player.animate("sequences.human_pickpocket")

        if (success) {
            if (data.coinPouch != null) {
                player.inventory.add(data.coinPouch)
            }
            player.addXp(Skills.THIEVING, data.xp)
            player.message("You successfully pick the ${npc.def.name}'s pocket.")

        } else {
            player.message("You fail to pick the ${npc.def.name}'s pocket.")
            npc.animate("sequences.human_unarmedpunch")
            player.hit((data.stunDamageMin..data.stunDamageMax).random())
            player.animate("sequences.stunned")
            // TODO: Implement stun time lock
        }
    }


}
