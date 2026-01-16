package org.alter.skills.thieving

import dev.openrune.ServerCacheManager
import io.github.oshai.kotlinlogging.KotlinLogging
import org.alter.api.Skills
import org.alter.api.ext.hit
import org.alter.api.ext.message
import org.alter.api.ext.stun
import org.alter.api.success
import org.alter.game.model.entity.Npc
import org.alter.game.model.entity.Player
import org.alter.game.model.weight.impl.WeightItem
import org.alter.game.model.weight.impl.WeightItemSet
import org.alter.game.pluginnew.PluginEvent
import org.alter.game.pluginnew.event.impl.NpcClickEvent
import org.alter.game.util.DbHelper
import org.alter.skills.thieving.PickPocketingDefinitions.npcDataByCategory
import org.alter.skills.thieving.PickPocketingDefinitions.npcDataById
import org.generated.tables.thieving.SkillThievingPickpocketingRow
import org.generated.tables.thieving.ThievingDroptableRow
import org.generated.tables.thieving.ThievingDroptableRow.Companion.id

class PickpocketingEvents : PluginEvent() {

    private val logger = KotlinLogging.logger {}

    val thievingDrops : MutableMap<Int, WeightItemSet> = emptyMap<Int, WeightItemSet>().toMutableMap()


    override fun init() {

        DbHelper.table("tables.thieving_droptable").forEach { rowData ->
            val rowId = rowData.id
            val dbRow = DbHelper.row(rowId)
            val data = ThievingDroptableRow(dbRow)

            val itemSet = WeightItemSet().apply {
                data.item.forEachIndexed { index, itemId ->
                    val weight = data.weight[index]
                    val amountRange = data.minAmount[index]..data.maxAmount[index]
                    add(WeightItem(itemId, amountRange, weight))
                }
            }

            thievingDrops[rowId] = itemSet
        }

        on<NpcClickEvent> {
            where { npcDataById(npc.id) != null }
            then {
                player.queue {
                    pickpocketNpc(player, npc, npcDataById(npc.id)!!)
                }
            }
            otherwise {
                where { npc.def.category != -1 && npc.def.actions.contains("Pickpocket") }
                then {
                    val data = npcDataByCategory(npc.def.category)
                    pickpocketNpc(player, npc, data!!)
                }
            }
        }
    }


    private fun canPickpocket(player: Player, npc: Npc, data: SkillThievingPickpocketingRow): String? {
        if (player.getSkills().getCurrentLevel(Skills.THIEVING) < data.level) {
            return "You need a thieving level of ${data.level} to pickpocket this NPC."
        }

        if (player.inventory.isFull()) {
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

        val table = thievingDrops[data.droptable]

        println(table)

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
            player.stun(data.stunDuration)
        }
    }


}
