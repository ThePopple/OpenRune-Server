package org.alter.impl.skills

import dev.openrune.definition.dbtables.DBTable
import dev.openrune.definition.dbtables.dbTable
import dev.openrune.definition.type.DBRowType
import dev.openrune.definition.type.DBTableType
import dev.openrune.definition.util.VarType
import org.alter.game.util.DbHelper.Companion.table
import org.alter.game.util.column
import org.alter.game.util.columnOptional
import org.alter.game.util.multiColumnOptional
import org.alter.game.util.vars.IntType
import org.alter.impl.*

const val XP = 0
const val LEVEL = 1
const val DROPTABLE = 2
const val CATEGORY = 3
const val NPCS = 4
const val STUN_DAMAGE_MIN = 5
const val STUN_DAMAGE_MAX = 6
const val STUN_DURATION = 7
const val LOW_CHANCE = 8
const val HIGH_CHANCE = 9

const val ITEM = 0
const val MIN_AMOUNT = 1
const val MAX_AMOUNT = 2
const val WEIGHT = 3

private const val ALWAYS = 0
private const val COMMON = 256
private const val UNCOMMON = 32
private const val RARE = 8
private const val VERY_RARE = 1

object Pickpocketing {
    // TODO: Implement Digsite Workmen
    // TODO: Implement Varlamore House shit
    // TODO: Implement blackjacking & relevant npcs etc

//    data class PickpocketNPCData(
//        val exp: Int,
//        val level: Int,
////        val DROPTABLE: DBRowType,
//        val category: Int,
//        val npcs: List<Int?>,
//        val stunDamageMin: Int,
//        val stunDamageMax: Int,
//        val stunDuration: Int,
//        val lowChance: Int,
//        val highChance: Int
//    )

    data class Drop(
        val item: String,
        val minAmount: Int,
        val maxAmount: Int,
        val weight: Int
    )
//
//    val definitions: List<PickpocketNPCData> = table("tables.skill_thieving_pickpocketing").map { row ->
//        val xp = row.column("columns.skill_thieving_pickpocketing:xp", IntType)
//        val level = row.column("columns.skill_thieving_pickpocketing:level", IntType)
//        val droptable = row.column("columns.skill_thieving_pickpocketing:droptable", DBTableType)
//        val category = row.columnOptional("columns.skill_thieving_pickpocketing:category", IntType) ?: -1
//        val npcs = row.multiColumnOptional("columns.skill_thieving_pickpocketing:npcs", IntType)
//        val stunDamageMin = row.column("columns.skill_thieving_pickpocketing:stun_damage_min", IntType)
//        val stunDamageMax = row.column("columns.skill_thieving_pickpocketing:stun_damage_max", IntType)
//        val stunDuration = row.column("columns.skill_thieving_pickpocketing:stun_duration", IntType)
//        val lowChance = row.column("columns.skill_thieving_pickpocketing:low_chance", IntType)
//        val highChance = row.column("columns.skill_thieving_pickpocketing:high_chance", IntType)
//
//
//        PickpocketNPCData(xp, level, category, npcs, stunDamageMin, stunDamageMax, stunDuration, lowChance, highChance)
//    }

//    fun byCategory(category: Int): PickpocketNPCData? {
//        if (category == -1) return null
//
//        return definitions.firstOrNull { it.category == category }
//    }
//
//    fun byNpcId(npcId: Int): PickpocketNPCData? {
//        return definitions.firstOrNull { it.npcs.contains(npcId) }
//    }

    fun npcs() = dbTable("tables.skill_thieving_pickpocketing") {
        column("xp", XP, VarType.INT)
        column("level", LEVEL, VarType.INT)
        column("droptable", DROPTABLE, VarType.DBTABLE)
        column("category", CATEGORY, VarType.INT)
        column("npcs", NPCS, VarType.INT)
        column("stun_damage_min", STUN_DAMAGE_MIN, VarType.INT)
        column("stun_damage_max", STUN_DAMAGE_MAX, VarType.INT)
        column("stun_duration", STUN_DURATION, VarType.INT)
        column("low_chance", LOW_CHANCE, VarType.INT)
        column("high_chance", HIGH_CHANCE, VarType.INT)

        row("dbrows.man") {
            column(XP, 8)
            column(LEVEL, 1)
            columnRSCM(DROPTABLE, "tables.man_pickpocketing_droptable")
            column(CATEGORY, 266)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 1)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.woman") {
            column(XP, 8)
            column(LEVEL, 1)
            columnRSCM(DROPTABLE, "tables.man_pickpocketing_droptable")
            column(CATEGORY, 492)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 1)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }


        row("dbrows.farmer") {
            column(XP, 14)
            column(LEVEL, 10)
            columnRSCM(DROPTABLE, "tables.farmer_pickpocketing_droptable")
            column(CATEGORY, 498)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 150)
            column(HIGH_CHANCE, 240)
        }


        row("dbrows.male_ham_member") {
            column(XP, 22)
            column(LEVEL, 15)
            columnRSCM(DROPTABLE, "tables.ham_member_pickpocketing_droptable")
            columnRSCM(NPCS, "npcs.favour_male_ham_civilian")
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 6)
            column(LOW_CHANCE, 135)
            column(HIGH_CHANCE, 239)
        }


        row("dbrows.female_ham_member") {
            column(XP, 22)
            column(LEVEL, 20)
            columnRSCM(DROPTABLE, "tables.ham_member_pickpocketing_droptable")
            columnRSCM(NPCS, "npcs.favour_female_ham_civilian")
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 6)
            column(LOW_CHANCE, 135)
            column(HIGH_CHANCE, 239)
        }

        row("dbrows.warrior") {
            column(XP, 26)
            column(LEVEL, 25)
            columnRSCM(DROPTABLE, "tables.warrior_pickpocketing_droptable")
            column(CATEGORY, 1728)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 100)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.al_kharid_warrior") {
            column(XP, 26)
            column(LEVEL, 25)
            columnRSCM(DROPTABLE, "tables.warrior_pickpocketing_droptable")
            columnRSCM(
                NPCS, "npcs.al_kharid_warrior"
            )
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 100)
            column(HIGH_CHANCE, 240)
        }


        row("dbrows.villager") {
            column(XP, 8)
            column(LEVEL, 25)
            columnRSCM(DROPTABLE, "tables.villager_pickpocketing_droptable")
            columnRSCM(NPCS, "npcs.feud_villager_1_1") // TODO: Add more npcs here
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 100)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.rogue") {
            column(XP, 36)
            column(LEVEL, 32)
            columnRSCM(DROPTABLE, "tables.rogue_pickpocketing_droptable")
            columnRSCM(NPCS, "npcs.rogue", "npcs.wilderness_rogue")
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 75)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.cave_goblin") {
            column(XP, 40)
            column(LEVEL, 36)
            columnRSCM(DROPTABLE, "tables.cave_goblin_pickpocketing_droptable")
            column(CATEGORY, 373)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 1)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 100)  // Couldn't find a value for these chances so just went with
            column(HIGH_CHANCE, 240) // the common 100/240
        }


        row("dbrows.master_farmer") {
            column(XP, 43)
            column(LEVEL, 38)
            columnRSCM(DROPTABLE, "tables.master_farmer_pickpocketing_droptable")
            column(CATEGORY, 641)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 8)
            column(LOW_CHANCE, 90)
            column(HIGH_CHANCE, 240)
        }


        row("dbrows.guard") {
            column(XP, 46)
            column(LEVEL, 40)
            columnRSCM(DROPTABLE, "tables.guard_pickpocketing_droptable")
            column(CATEGORY, 470)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 8)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        // TODO: Add npcs to this, can't find any currently
        row("dbrows.fremennik_citizen") {
            column(XP, 65)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "tables.fremennik_citizen_pickpocketing_droptable")
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.desert_bandit") {
            column(XP, 79)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "tables.desert_bandit_pickpocketing_droptable")
            columnRSCM(NPCS, "npcs.fourdiamonds_sword_bandit_1", "npcs.fourdiamonds_sword_bandit_free")
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.knight_of_ardougne") {
            column(XP, 84)
            column(LEVEL, 55)
            columnRSCM(DROPTABLE, "tables.knight_pickpocketing_droptable")
            column(CATEGORY, 1731)
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        // TODO: Add npcs to this, can't find any currently
        row("dbrows.knight_of_varlamore") {
            column(XP, 84)
            column(LEVEL, 55)
            column(CATEGORY, 1977)
            columnRSCM(DROPTABLE, "tables.knight_pickpocketing_droptable")
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.yanille_watchman") {
            column(XP, 137)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "tables.watchman_pickpocketing_droptable")
            columnRSCM(NPCS, "npcs.yanille_watchman")
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.paladin") {
            column(XP, 131)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "tables.paladin_pickpocketing_droptable")
            column(CATEGORY, 1729)
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.gnome") {
            column(XP, 133)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "tables.gnome_pickpocketing_droptable")
            column(CATEGORY, 354)
            column(STUN_DAMAGE_MIN, 3)
            column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.hero") {
            column(XP, 163)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "tables.hero_pickpocketing_droptable")
            column(CATEGORY, 1730)
            column(STUN_DAMAGE_MIN, 3)
            column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.vyre") {
            column(XP, 306)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "tables.vyre_pickpocketing_droptable")
            column(CATEGORY, 1451)
            column(STUN_DAMAGE_MIN, 3)
            column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.elf") {
            column(XP, 353)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "tables.elf_pickpocketing_droptable")
            column(CATEGORY, 1392)
            column(STUN_DAMAGE_MIN, 3)
            column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        // TODO: Add npcs to this, unsure which to use
        row("dbrows.tzhaar") {
            column(XP, 103)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "tables.tzhaar_pickpocketing_droptable")
            column(CATEGORY, 431)
            column(STUN_DAMAGE_MIN, 3)
            column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

    }

    val manDropTable = createDropTable("tables.man_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_citizen", 1, 1, ALWAYS),
    ))

    val farmerDropTable = createDropTable("tables.farmer_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_farmer", 1, 1, ALWAYS),
        Drop("items.potato_seed", 1, 1, RARE),
    ))

    val hamMemberDropTable = createDropTable("tables.ham_member_pickpocketing_droptable", listOf(
        Drop("items.bronze_arrow", 1, 15, COMMON),
        Drop("items.bronze_axe", 1, 1, COMMON),
        Drop("items.bronze_pickaxe", 1, 1, COMMON),
        Drop("items.iron_axe", 1, 1, COMMON),
        Drop("items.iron_dagger", 1, 1, COMMON),
        Drop("items.iron_pickaxe", 1, 1, COMMON),
        Drop("items.digsitebuttons", 1, 1, COMMON),
        Drop("items.pickpocket_coin_pouch_ham", 1, 1, COMMON),
        Drop("items.feather", 1, 7, COMMON),
        Drop("items.knife", 1, 1, COMMON),
        Drop("items.logs", 1, 1, COMMON),
        Drop("items.needle", 1, 1, COMMON),
        Drop("items.raw_anchovies", 1, 3, COMMON),
        Drop("items.raw_chicken", 1, 1, COMMON),
        Drop("items.thread", 2, 10, COMMON),
        Drop("items.tinderbox", 1, 1, COMMON),
        Drop("items.uncut_opal", 1, 1, COMMON),
        Drop("items.leather_armour", 1, 1, UNCOMMON),
        Drop("items.ham_boots", 1, 1, UNCOMMON),
        Drop("items.ham_cloak", 1, 1, UNCOMMON),
        Drop("items.ham_gloves", 1, 1, UNCOMMON),
        Drop("items.ham_hood", 1, 1, UNCOMMON),
        Drop("items.ham_badge", 1, 1, UNCOMMON),
        Drop("items.ham_shirt", 1, 1, UNCOMMON),
        Drop("items.steel_arrow", 1, 13, UNCOMMON),
        Drop("items.steel_axe", 1, 1, UNCOMMON),
        Drop("items.steel_dagger", 1, 1, UNCOMMON),
        Drop("items.steel_pickaxe", 1, 1, UNCOMMON),
        Drop("items.trail_clue_easy_simple001", 1, 1, UNCOMMON),
        Drop("items.coal", 1, 1, UNCOMMON),
        Drop("items.cow_hide", 1, 1, UNCOMMON),
        Drop("items.digsitearmour1", 1, 1, UNCOMMON),
        Drop("items.unidentified_guam", 1, 1, UNCOMMON),
        Drop("items.unidentified_marentill", 1, 1, UNCOMMON),
        Drop("items.unidentified_tarromin", 1, 1, UNCOMMON),
        Drop("items.iron_ore", 1, 1, UNCOMMON),
        Drop("items.digsitesword", 1, 1, UNCOMMON),
        Drop("items.uncut_jade", 1, 1, UNCOMMON),
    ))

    val warriorDropTable = createDropTable("tables.warrior_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_warrior", 1, 1, ALWAYS),
    ))

    val villagerDropTable = createDropTable("tables.villager_pickpocketing_droptable", listOf(
        Drop("items.coins", 5, 5, ALWAYS),
    ))

    val rogueDropTable = createDropTable("tables.rogue_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_rogue", 1, 1, ALWAYS),
        Drop("items.ring_of_dueling_1", 1, 1, RARE),
        Drop("items.ring_of_dueling_2", 1, 1, RARE),
        Drop("items.ring_of_dueling_3", 1, 1, RARE),
        Drop("items.ring_of_dueling_4", 1, 1, RARE),
        Drop("items.trail_clue_easy_simple001", 1, 1, VERY_RARE),
    ))

    val caveGoblinDropTable = createDropTable("tables.cave_goblin_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_cavegoblin", 25, 120, ALWAYS),
        Drop("items.airrune", 8, 8, COMMON),
        Drop("items.lockpick", 1, 1, VERY_RARE),
        Drop("items.jug_wine", 1, 1, UNCOMMON),
        Drop("items.gold_bar", 1, 1, RARE),
        Drop("items.iron_dagger_p", 1, 1, RARE),
    ))

    val masterFarmerDropTable = createDropTable("tables.master_farmer_pickpocketing_droptable", listOf(
        Drop("items.potato_seed", 1, 4, COMMON),
        Drop("items.onion_seed", 1, 3, COMMON),
        Drop("items.cabbage_seed", 1, 3, COMMON),
        Drop("items.tomato_seed", 1, 2, COMMON),
        Drop("items.sweetcorn_seed", 1, 2, UNCOMMON),
        Drop("items.strawberry_seed", 1, 1, UNCOMMON),
        Drop("items.watermelon_seed", 1, 1, RARE),
        Drop("items.barley_seed", 1, 4, COMMON),
        Drop("items.hammerstone_hop_seed", 1, 3, COMMON),
        Drop("items.asgarnian_hop_seed", 1, 2, COMMON),
        Drop("items.jute_seed", 1, 3, COMMON),
        Drop("items.yanillian_hop_seed", 1, 2, UNCOMMON),
        Drop("items.krandorian_hop_seed", 1, 1, UNCOMMON),
        Drop("items.wildblood_hop_seed", 1, 1, RARE),
        Drop("items.marigold_seed", 1, 1, COMMON),
        Drop("items.nasturtium_seed", 1, 1, UNCOMMON),
        Drop("items.rosemary_seed", 1, 1, UNCOMMON),
        Drop("items.woad_seed", 1, 1, UNCOMMON),
        Drop("items.limpwurt_seed", 1, 1, UNCOMMON),
        Drop("items.redberry_bush_seed", 1, 1, COMMON),
        Drop("items.cadavaberry_bush_seed", 1, 1, UNCOMMON),
        Drop("items.dwellberry_bush_seed", 1, 1, UNCOMMON),
        Drop("items.jangerberry_bush_seed", 1, 1, RARE),
        Drop("items.whiteberry_bush_seed", 1, 1, RARE),
        Drop("items.poisonivy_bush_seed", 1, 1, RARE),
        Drop("items.guam_seed", 1, 1, UNCOMMON),
        Drop("items.marrentill_seed", 1, 1, UNCOMMON),
        Drop("items.tarromin_seed", 1, 1, RARE),
        Drop("items.harralander_seed", 1, 1, RARE),
        Drop("items.ranarr_seed", 1, 1, RARE),
        Drop("items.toadflax_seed", 1, 1, RARE),
        Drop("items.irit_seed", 1, 1, RARE),
        Drop("items.avantoe_seed", 1, 1, RARE),
        Drop("items.kwuarm_seed", 1, 1, VERY_RARE),
        Drop("items.snapdragon_seed", 1, 1, VERY_RARE),
        Drop("items.cadantine_seed", 1, 1, VERY_RARE),
        Drop("items.lantadyme_seed", 1, 1, VERY_RARE),
        Drop("items.dwarf_weed_seed", 1, 1, VERY_RARE),
        Drop("items.torstol_seed", 1, 1, VERY_RARE),
        Drop("items.mushroom_spore_2", 1, 1, RARE), // Unsure if this is the right spore
        Drop("items.belladonna_seed", 1, 1, RARE),
        Drop("items.cactus_seed", 1, 1, VERY_RARE),
    ))


    val guardDropTable = createDropTable("tables.guard_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_guard", 1, 1, ALWAYS),
    ))

    val fremennikCitizenDropTable = createDropTable("tables.fremennik_citizen_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_fremennik", 1, 1, ALWAYS),
    ))

    val desertBanditDropTable = createDropTable("tables.desert_bandit_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_desertbandit", 1, 1, ALWAYS),
    ))

    val knightOfArdougneDropTable = createDropTable("tables.knight_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_knight", 1, 1, ALWAYS),
    ))

    val yanilleWatchmanDropTable = createDropTable("tables.watchman_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_watchman", 1, 1, ALWAYS),
    ))

    val paladinDropTable = createDropTable("tables.paladin_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_paladin", 1, 1, ALWAYS),
        Drop("items.chaosrune", 2, 2, COMMON),
    ))

    val gnomeDropTable = createDropTable("tables.gnome_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_gnome", 300, 300, COMMON),
        Drop("items.earthrune", 1, 1, COMMON),
        Drop("items.gold_ore", 1, 1, COMMON),
        Drop("items.fire_orb", 1, 1, COMMON),
        Drop("items.swamp_toad", 1, 1, COMMON),
        Drop("items.king_worm", 1, 1, COMMON),
    ))

    val heroDropTable = createDropTable("tables.hero_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_hero", 200, 300, COMMON),
        Drop("items.deathrune", 2, 2, UNCOMMON),
        Drop("items.bloodrune", 1, 1, UNCOMMON),
        Drop("items.gold_ore", 1, 1, UNCOMMON),
        Drop("items.jug_wine", 1, 1, UNCOMMON),
        Drop("items.fire_orb", 1, 1, UNCOMMON),
        Drop("items.diamond", 1, 1, UNCOMMON),
    ))

    val vyreDropTable = createDropTable("tables.vyre_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_vyre", 1, 1, ALWAYS),
    ))

    val elfDropTable = createDropTable("tables.elf_pickpocketing_droptable", listOf(
        Drop("items.pickpocket_coin_pouch_elf", 1, 1, ALWAYS),
    ))

    val tzhaarDropTable = createDropTable("tables.tzhaar_pickpocketing_droptable", listOf(
        Drop("items.tzhaar_token", 1, 16, COMMON),
        Drop("items.uncut_sapphire", 1, 1, COMMON),
        Drop("items.uncut_emerald", 1, 1, COMMON),
        Drop("items.uncut_ruby", 1, 1, COMMON),
        Drop("items.uncut_diamond", 1, 1, COMMON),
    ))

    private fun createDropTable(tableId: String, drops: List<Drop>): DBTable {
        return dbTable(tableId) {
            column("item", ITEM, VarType.OBJ)
            column("min_amount", MIN_AMOUNT, VarType.INT)
            column("max_amount", MAX_AMOUNT, VarType.INT)
            column("weight", WEIGHT, VarType.INT)

            drops.forEachIndexed { index, drop ->
                row(index) {
                    columnRSCM(ITEM, drop.item)
                    column(MIN_AMOUNT, drop.minAmount)
                    column(MAX_AMOUNT, drop.maxAmount)
                    column(WEIGHT, drop.weight)
                }
            }
        }
    }
}
