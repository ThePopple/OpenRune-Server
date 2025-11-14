package org.alter.skills.thieving

import org.alter.game.util.DbHelper.Companion.table
import org.alter.game.util.column
import org.alter.game.util.multiColumn
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
        val xp = row.column("columns.columns.skill_thieving_pickpocketing:xp", IntType)
        val level = row.column("columns.columns.skill_thieving_pickpocketing:level", IntType)
//        val droptable = row.column("columns.columns.skill_thieving_pickpocketing:droptable", DBRowType)
        val category = row.column("columns.columns.skill_thieving_pickpocketing:category", IntType)
        val npcs = row.multiColumn("columns.columns.skill_thieving_pickpocketing:npcs", IntType)
        val stunDamageMin = row.column("columns.columns.skill_thieving_pickpocketing:stun_damage_min", IntType)
        val stunDamageMax = row.column("columns.columns.skill_thieving_pickpocketing:stun_damage_max", IntType)
        val stunDuration = row.column("columns.columns.skill_thieving_pickpocketing:stun_duration", IntType)
        val lowChance = row.column("columns.columns.skill_thieving_pickpocketing:low_chance", IntType)
        val highChance = row.column("columns.columns.skill_thieving_pickpocketing:high_chance", IntType)

        PickpocketNPCData(xp, level, category, npcs, stunDamageMin, stunDamageMax, stunDuration, lowChance, highChance)
    }

    fun byCategory(category: Int): PickpocketNPCData? {
        if (category == -1) return null

        return definitions.first { it.category == category }
    }
}
