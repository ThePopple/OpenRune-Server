package org.alter.skills.thieving

import org.generated.tables.*
import org.generated.tables.thieving.SkillThievingPickpocketingRow

object PickPocketingDefinitions {
    val npcData = SkillThievingPickpocketingRow.all()

    fun npcDataById(id: Int): SkillThievingPickpocketingRow? =
        npcData.firstOrNull { it.npcs.contains(id) }

    fun npcDataByCategory(category: Int): SkillThievingPickpocketingRow? =
        npcData.firstOrNull { it.category == category }

    val manDropTable = ManPickpocketingDroptableRow.all()
    val farmerDropTable = FarmerPickpocketingDroptableRow.all()
    val hamMemberDropTable = HamMemberPickpocketingDroptableRow.all()
    val warriorDropTable = WarriorPickpocketingDroptableRow.all()
    val villagerDropTable = VillagerPickpocketingDroptableRow.all()
    val rogueDropTable = RoguePickpocketingDroptableRow.all()
    val caveGoblinDropTable = CaveGoblinPickpocketingDroptableRow.all()
    val masterFarmerDropTable = MasterFarmerPickpocketingDroptableRow.all()
    val guardDropTable = GuardPickpocketingDroptableRow.all()
    val fremennikCitizenDropTable = FremennikCitizenPickpocketingDroptableRow.all()
    val desertBanditDropTable = DesertBanditPickpocketingDroptableRow.all()
    val knightDropTable = KnightPickpocketingDroptableRow.all()
    val WatchmanDropTable = WatchmanPickpocketingDroptableRow.all()
    val paladinDropTable = PaladinPickpocketingDroptableRow.all()
    val gnomeDropTable = GnomePickpocketingDroptableRow.all()
    val heroDropTable = HeroPickpocketingDroptableRow.all()
    val vyreDropTable = VyrePickpocketingDroptableRow.all()
    val elfDropTable = ElfPickpocketingDroptableRow.all()
    val tzhaarDropTable = TzhaarPickpocketingDroptableRow.all()
}