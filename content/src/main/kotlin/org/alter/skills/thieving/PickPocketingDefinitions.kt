package org.alter.skills.thieving

import org.generated.tables.*
import org.generated.tables.thieving.SkillThievingPickpocketingRow

object PickPocketingDefinitions {
    val npcData = SkillThievingPickpocketingRow.all()

    fun npcDataById(id: Int): SkillThievingPickpocketingRow? =
        npcData.firstOrNull { it.npcs.contains(id) }

    fun npcDataByCategory(category: Int): SkillThievingPickpocketingRow? =
        npcData.firstOrNull { it.category == category }

}