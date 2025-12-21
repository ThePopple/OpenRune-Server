package org.alter.impl.skills.thieving

import dev.openrune.definition.dbtables.DBTable
import dev.openrune.definition.dbtables.dbTable
import dev.openrune.definition.util.VarType

const val XP = 0
const val LEVEL = 1
const val DROPTABLE = 2
const val COIN_POUCH = 3
const val CATEGORY = 4
const val NPCS = 5
const val STUN_DAMAGE_MIN = 6
const val STUN_DAMAGE_MAX = 7
const val STUN_DURATION = 8
const val LOW_CHANCE = 9
const val HIGH_CHANCE = 10

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

    data class WeightedItem(
        val item: String,
        val minAmount: Int,
        val maxAmount: Int,
        val weight: Int,
    )

    fun npcs() = dbTable("tables.skill_thieving_pickpocketing") {
        column("xp", XP, VarType.INT)
        column("level", LEVEL, VarType.INT)
        column("droptable", DROPTABLE, VarType.DBTABLE)
        column("coin_pouch", COIN_POUCH, VarType.OBJ)
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_citizen")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_citizen")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_farmer")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_ham")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_ham")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_warrior")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_warrior")
            columnRSCM(NPCS, "npcs.al_kharid_warrior")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_rogue")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_cavegoblin")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_guard")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_fremennik")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_bandit")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_knight")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_knight")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_watchman")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_paladin")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_gnome")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_hero")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_vyre")
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
            // columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_elf")
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

    val manDropTable = createDropTable("tables.man_pickpocketing_droptable", listOf())

    val farmerDropTable = createDropTable(
        "tables.farmer_pickpocketing_droptable", listOf(
            WeightedItem("items.potato_seed", 1, 1, RARE),
        )
    )

    val hamMemberDropTable = createDropTable(
        "tables.ham_member_pickpocketing_droptable", listOf(
            WeightedItem("items.bronze_arrow", 1, 15, COMMON),
            WeightedItem("items.bronze_axe", 1, 1, COMMON),
            WeightedItem("items.bronze_pickaxe", 1, 1, COMMON),
            WeightedItem("items.iron_axe", 1, 1, COMMON),
            WeightedItem("items.iron_dagger", 1, 1, COMMON),
            WeightedItem("items.iron_pickaxe", 1, 1, COMMON),
            WeightedItem("items.digsitebuttons", 1, 1, COMMON),
            WeightedItem("items.feather", 1, 7, COMMON),
            WeightedItem("items.knife", 1, 1, COMMON),
            WeightedItem("items.logs", 1, 1, COMMON),
            WeightedItem("items.needle", 1, 1, COMMON),
            WeightedItem("items.raw_anchovies", 1, 3, COMMON),
            WeightedItem("items.raw_chicken", 1, 1, COMMON),
            WeightedItem("items.thread", 2, 10, COMMON),
            WeightedItem("items.tinderbox", 1, 1, COMMON),
            WeightedItem("items.uncut_opal", 1, 1, COMMON),
            WeightedItem("items.leather_armour", 1, 1, UNCOMMON),
            WeightedItem("items.ham_boots", 1, 1, UNCOMMON),
            WeightedItem("items.ham_cloak", 1, 1, UNCOMMON),
            WeightedItem("items.ham_gloves", 1, 1, UNCOMMON),
            WeightedItem("items.ham_hood", 1, 1, UNCOMMON),
            WeightedItem("items.ham_badge", 1, 1, UNCOMMON),
            WeightedItem("items.ham_shirt", 1, 1, UNCOMMON),
            WeightedItem("items.steel_arrow", 1, 13, UNCOMMON),
            WeightedItem("items.steel_axe", 1, 1, UNCOMMON),
            WeightedItem("items.steel_dagger", 1, 1, UNCOMMON),
            WeightedItem("items.steel_pickaxe", 1, 1, UNCOMMON),
            WeightedItem("items.trail_clue_easy_simple001", 1, 1, UNCOMMON),
            WeightedItem("items.coal", 1, 1, UNCOMMON),
            WeightedItem("items.cow_hide", 1, 1, UNCOMMON),
            WeightedItem("items.digsitearmour1", 1, 1, UNCOMMON),
            WeightedItem("items.unidentified_guam", 1, 1, UNCOMMON),
            WeightedItem("items.unidentified_marentill", 1, 1, UNCOMMON),
            WeightedItem("items.unidentified_tarromin", 1, 1, UNCOMMON),
            WeightedItem("items.iron_ore", 1, 1, UNCOMMON),
            WeightedItem("items.digsitesword", 1, 1, UNCOMMON),
            WeightedItem("items.uncut_jade", 1, 1, UNCOMMON),
        )
    )

    val warriorDropTable = createDropTable(
        "tables.warrior_pickpocketing_droptable", listOf()
    )

    val villagerDropTable = createDropTable(
        "tables.villager_pickpocketing_droptable", listOf(
            WeightedItem("items.coins", 5, 5, ALWAYS),
        )
    )

    val rogueDropTable = createDropTable(
        "tables.rogue_pickpocketing_droptable", listOf(
            WeightedItem("items.ring_of_dueling_1", 1, 1, RARE),
            WeightedItem("items.ring_of_dueling_2", 1, 1, RARE),
            WeightedItem("items.ring_of_dueling_3", 1, 1, RARE),
            WeightedItem("items.ring_of_dueling_4", 1, 1, RARE),
            WeightedItem("items.trail_clue_easy_simple001", 1, 1, VERY_RARE),
        )
    )

    val caveGoblinDropTable = createDropTable(
        "tables.cave_goblin_pickpocketing_droptable", listOf(
            WeightedItem("items.airrune", 8, 8, COMMON),
            WeightedItem("items.lockpick", 1, 1, VERY_RARE),
            WeightedItem("items.jug_wine", 1, 1, UNCOMMON),
            WeightedItem("items.gold_bar", 1, 1, RARE),
            WeightedItem("items.iron_dagger_p", 1, 1, RARE),
        )
    )

    val masterFarmerDropTable = createDropTable(
        "tables.master_farmer_pickpocketing_droptable", listOf(
            WeightedItem("items.potato_seed", 1, 4, COMMON),
            WeightedItem("items.onion_seed", 1, 3, COMMON),
            WeightedItem("items.cabbage_seed", 1, 3, COMMON),
            WeightedItem("items.tomato_seed", 1, 2, COMMON),
            WeightedItem("items.sweetcorn_seed", 1, 2, UNCOMMON),
            WeightedItem("items.strawberry_seed", 1, 1, UNCOMMON),
            WeightedItem("items.watermelon_seed", 1, 1, RARE),
            WeightedItem("items.barley_seed", 1, 4, COMMON),
            WeightedItem("items.hammerstone_hop_seed", 1, 3, COMMON),
            WeightedItem("items.asgarnian_hop_seed", 1, 2, COMMON),
            WeightedItem("items.jute_seed", 1, 3, COMMON),
            WeightedItem("items.yanillian_hop_seed", 1, 2, UNCOMMON),
            WeightedItem("items.krandorian_hop_seed", 1, 1, UNCOMMON),
            WeightedItem("items.wildblood_hop_seed", 1, 1, RARE),
            WeightedItem("items.marigold_seed", 1, 1, COMMON),
            WeightedItem("items.nasturtium_seed", 1, 1, UNCOMMON),
            WeightedItem("items.rosemary_seed", 1, 1, UNCOMMON),
            WeightedItem("items.woad_seed", 1, 1, UNCOMMON),
            WeightedItem("items.limpwurt_seed", 1, 1, UNCOMMON),
            WeightedItem("items.redberry_bush_seed", 1, 1, COMMON),
            WeightedItem("items.cadavaberry_bush_seed", 1, 1, UNCOMMON),
            WeightedItem("items.dwellberry_bush_seed", 1, 1, UNCOMMON),
            WeightedItem("items.jangerberry_bush_seed", 1, 1, RARE),
            WeightedItem("items.whiteberry_bush_seed", 1, 1, RARE),
            WeightedItem("items.poisonivy_bush_seed", 1, 1, RARE),
            WeightedItem("items.guam_seed", 1, 1, UNCOMMON),
            WeightedItem("items.marrentill_seed", 1, 1, UNCOMMON),
            WeightedItem("items.tarromin_seed", 1, 1, RARE),
            WeightedItem("items.harralander_seed", 1, 1, RARE),
            WeightedItem("items.ranarr_seed", 1, 1, RARE),
            WeightedItem("items.toadflax_seed", 1, 1, RARE),
            WeightedItem("items.irit_seed", 1, 1, RARE),
            WeightedItem("items.avantoe_seed", 1, 1, RARE),
            WeightedItem("items.kwuarm_seed", 1, 1, VERY_RARE),
            WeightedItem("items.snapdragon_seed", 1, 1, VERY_RARE),
            WeightedItem("items.cadantine_seed", 1, 1, VERY_RARE),
            WeightedItem("items.lantadyme_seed", 1, 1, VERY_RARE),
            WeightedItem("items.dwarf_weed_seed", 1, 1, VERY_RARE),
            WeightedItem("items.torstol_seed", 1, 1, VERY_RARE),
            WeightedItem("items.mushroom_spore_2", 1, 1, RARE), // Unsure if this is the right spore
            WeightedItem("items.belladonna_seed", 1, 1, RARE),
            WeightedItem("items.cactus_seed", 1, 1, VERY_RARE),
        )
    )


    val guardDropTable = createDropTable("tables.guard_pickpocketing_droptable", listOf())

    val fremennikCitizenDropTable = createDropTable("tables.fremennik_citizen_pickpocketing_droptable", listOf())

    val desertBanditDropTable = createDropTable("tables.desert_bandit_pickpocketing_droptable", listOf())

    val knightOfArdougneDropTable = createDropTable("tables.knight_pickpocketing_droptable", listOf())

    val yanilleWatchmanDropTable = createDropTable("tables.watchman_pickpocketing_droptable", listOf())

    val paladinDropTable = createDropTable(
        "tables.paladin_pickpocketing_droptable", listOf(
            WeightedItem("items.chaosrune", 2, 2, COMMON),
        )
    )

    val gnomeDropTable = createDropTable(
        "tables.gnome_pickpocketing_droptable", listOf(
            WeightedItem("items.earthrune", 1, 1, COMMON),
            WeightedItem("items.gold_ore", 1, 1, COMMON),
            WeightedItem("items.fire_orb", 1, 1, COMMON),
            WeightedItem("items.swamp_toad", 1, 1, COMMON),
            WeightedItem("items.king_worm", 1, 1, COMMON),
            WeightedItem("items.arrow_shaft", 1, 1, COMMON),
        )
    )

    val heroDropTable = createDropTable(
        "tables.hero_pickpocketing_droptable", listOf(
            WeightedItem("items.deathrune", 2, 2, UNCOMMON),
            WeightedItem("items.bloodrune", 1, 1, UNCOMMON),
            WeightedItem("items.gold_ore", 1, 1, UNCOMMON),
            WeightedItem("items.jug_wine", 1, 1, UNCOMMON),
            WeightedItem("items.fire_orb", 1, 1, UNCOMMON),
            WeightedItem("items.diamond", 1, 1, UNCOMMON),
        )
    )

    val vyreDropTable = createDropTable("tables.vyre_pickpocketing_droptable", listOf())

    val elfDropTable = createDropTable("tables.elf_pickpocketing_droptable", listOf())

    val tzhaarDropTable = createDropTable(
        "tables.tzhaar_pickpocketing_droptable", listOf(
            WeightedItem("items.tzhaar_token", 1, 16, COMMON),
            WeightedItem("items.uncut_sapphire", 1, 1, COMMON),
            WeightedItem("items.uncut_emerald", 1, 1, COMMON),
            WeightedItem("items.uncut_ruby", 1, 1, COMMON),
            WeightedItem("items.uncut_diamond", 1, 1, COMMON),
        )
    )

    private fun createDropTable(tableId: String, drops: List<WeightedItem>): DBTable {
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
