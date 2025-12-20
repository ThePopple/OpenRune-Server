package org.alter.impl.skills

import org.alter.game.util.DbHelper.Companion.table
import org.alter.game.util.column
import org.alter.game.util.columnOptional
import org.alter.game.util.multiColumnOptional
import org.alter.game.util.vars.IntType

object Pickpocketing {

    data class PickpocketNPCData(
        val exp: Int,
        val level: Int,
//        val DROPTABLE, // TODO: Implement droptables etc
        val category: Int,
        val npcs: List<Int?>,
        val stunDamageMin: Int,
        val stunDamageMax: Int,
        val stunDuration: Int,
        val lowChance: Int,
        val highChance: Int
    )

    val definitions: List<PickpocketNPCData> = table("tables.skill_thieving_pickpocketing").map { row ->
        val xp = row.column("columns.skill_thieving_pickpocketing:xp", IntType)
        val level = row.column("columns.skill_thieving_pickpocketing:level", IntType)
//        val droptable = row.column("columns.skill_thieving_pickpocketing:droptable", DBRowType)
        val category = row.columnOptional("columns.skill_thieving_pickpocketing:category", IntType) ?: -1
        val npcs = row.multiColumnOptional("columns.skill_thieving_pickpocketing:npcs", IntType)
        val stunDamageMin = row.column("columns.skill_thieving_pickpocketing:stun_damage_min", IntType)
        val stunDamageMax = row.column("columns.skill_thieving_pickpocketing:stun_damage_max", IntType)
        val stunDuration = row.column("columns.skill_thieving_pickpocketing:stun_duration", IntType)
        val lowChance = row.column("columns.skill_thieving_pickpocketing:low_chance", IntType)
        val highChance = row.column("columns.skill_thieving_pickpocketing:high_chance", IntType)


        PickpocketNPCData(xp, level, category, npcs, stunDamageMin, stunDamageMax, stunDuration, lowChance, highChance)
    }

    fun byCategory(category: Int): PickpocketNPCData? {
        if (category == -1) return null

        return definitions.firstOrNull { it.category == category }
    }

    fun byNpcId(npcId: Int): PickpocketNPCData? {
        return definitions.firstOrNull { it.npcs.contains(npcId) }
    }
}
