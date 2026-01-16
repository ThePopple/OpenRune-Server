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
            columnRSCM(DROPTABLE, "dbrows.man_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_citizen")
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
            columnRSCM(DROPTABLE, "dbrows.man_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_citizen")
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
            columnRSCM(DROPTABLE, "dbrows.farmer_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_farmer")
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
            columnRSCM(DROPTABLE, "dbrows.ham_member_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_ham")
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
            columnRSCM(DROPTABLE, "dbrows.ham_member_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_ham")
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
            columnRSCM(DROPTABLE, "dbrows.warrior_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_warrior")
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
            columnRSCM(DROPTABLE, "dbrows.warrior_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_warrior")
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
            columnRSCM(DROPTABLE, "dbrows.villager_pickpocketing_droptable")
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
            columnRSCM(DROPTABLE, "dbrows.rogue_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_rogue")
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
            columnRSCM(DROPTABLE, "dbrows.cave_goblin_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_cavegoblin")
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
            columnRSCM(DROPTABLE, "dbrows.master_farmer_pickpocketing_droptable")
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
            columnRSCM(DROPTABLE, "dbrows.guard_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_guard")
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
            columnRSCM(DROPTABLE, "dbrows.fremennik_citizen_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_fremennik")
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.desert_bandit") {
            column(XP, 79)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "dbrows.desert_bandit_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_bandit")
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
            columnRSCM(DROPTABLE, "dbrows.knight_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_knight")
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
            columnRSCM(DROPTABLE, "dbrows.knight_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_knight")
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.yanille_watchman") {
            column(XP, 137)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "dbrows.watchman_pickpocketing_droptable")
            columnRSCM(NPCS, "npcs.yanille_watchman")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_watchman")
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.paladin") {
            column(XP, 131)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "dbrows.paladin_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_paladin")
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
            columnRSCM(DROPTABLE, "dbrows.gnome_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_gnome")
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
            columnRSCM(DROPTABLE, "dbrows.hero_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_hero")
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
            columnRSCM(DROPTABLE, "dbrows.vyre_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_vyre")
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
            columnRSCM(DROPTABLE, "dbrows.elf_pickpocketing_droptable")
            columnRSCM(COIN_POUCH, "items.pickpocket_coin_pouch_elf")
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
            columnRSCM(DROPTABLE, "dbrows.tzhaar_pickpocketing_droptable")
            column(CATEGORY, 431)
            column(STUN_DAMAGE_MIN, 3)
            column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

    }



}

