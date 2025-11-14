package org.alter.impl

import dev.openrune.definition.dbtables.dbTable
import dev.openrune.definition.util.VarType

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

object PickpocketingTable {
    // TODO: Implement Digsite Workmen
    // TODO: Implement Varlamore House shit
    // TODO: Implement blackjacking & relevant npcs etc

    fun skillTable() = dbTable("tables.skill_thieving_pickpocketing") {
        column("xp", XP, VarType.INT)
        column("level", LEVEL, VarType.INT)
        column("droptable", DROPTABLE, VarType.DBROW)
        column("category", CATEGORY, VarType.INT)
        column("npcs", NPCS, VarType.NPC)
        column("stun_damage_min", STUN_DAMAGE_MIN, VarType.INT)
        column("stun_damage_max", STUN_DAMAGE_MAX, VarType.INT)
        column("stun_duration", STUN_DURATION, VarType.INT)
        column("low_chance", LOW_CHANCE, VarType.INT)
        column("high_chance", HIGH_CHANCE, VarType.INT)

        row("dbrows.thieving_man") {
            column(XP, 8)
            column(LEVEL, 1)
            columnRSCM(DROPTABLE, "dbrows.thieving_man_drops")
            column(CATEGORY, 266)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 1)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_woman") {
            column(XP, 8)
            column(LEVEL, 1)
            columnRSCM(DROPTABLE, "dbrows.thieving_man_drops")
            column(CATEGORY, 492)
            column(STUN_DAMAGE_MIN, 1, 1)
            column(STUN_DAMAGE_MAX, 1)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }


        row("dbrows.thieving_farmer") {
            column(XP, 14)
            column(LEVEL, 10)
            columnRSCM(DROPTABLE, "dbrows.thieving_farmer_drops")
            column(CATEGORY, 498)
            column(STUN_DAMAGE_MIN, 1, 2)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 150)
            column(HIGH_CHANCE, 240)
        }


        row("dbrows.thieving_male_ham_member") {
            column(XP, 22)
            column(LEVEL, 15)
            columnRSCM(DROPTABLE, "dbrows.thieving_ham_member_drops")
            columnRSCM(NPCS, "npcs.favour_male_ham_civilian")
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 6)
            column(LOW_CHANCE, 135)
            column(HIGH_CHANCE, 239)
        }


        row("dbrows.thieving_female_ham_member") {
            column(XP, 22)
            column(LEVEL, 20)
            columnRSCM(DROPTABLE, "dbrows.thieving_ham_member_drops")
            columnRSCM(NPCS, "npcs.favour_female_ham_civilian")
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 6)
            column(LOW_CHANCE, 135)
            column(HIGH_CHANCE, 239)
        }

        row("dbrows.thieving_warrior") {
            column(XP, 26)
            column(LEVEL, 25)
            columnRSCM(DROPTABLE, "dbrows.thieving_warrior_drops")
            column(CATEGORY, 1728)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 100)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_al_kharid_warrior") {
            column(XP, 26)
            column(LEVEL, 25)
            columnRSCM(DROPTABLE, "dbrows.thieving_warrior_drops")
            columnRSCM(
                NPCS, "npcs.al_kharid_warrior"
            )
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 100)
            column(HIGH_CHANCE, 240)
        }


        row("dbrows.thieving_villager") {
            column(XP, 8)
            column(LEVEL, 25)
            columnRSCM(DROPTABLE, "dbrows.thieving_villager_drops")
            columnRSCM(NPCS, "npcs.feud_villager_1_1") // TODO: Add more npcs here
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 100)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_rogue") {
            column(XP, 36)
            column(LEVEL, 32)
            columnRSCM(DROPTABLE, "dbrows.thieving_rogue_drops")
            columnRSCM(NPCS, "npcs.rogue", "npcs.wilderness_rogue")
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 75)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_cave_goblin") {
            column(XP, 40)
            column(LEVEL, 36)
            columnRSCM(DROPTABLE, "dbrows.thieving_cave_goblin_drops")
            column(CATEGORY, 373)
            column(STUN_DAMAGE_MIN, 1, 1)
            column(STUN_DAMAGE_MAX, 1)
            column(STUN_DURATION, 7)
            column(LOW_CHANCE, 100)  // Couldn't find a value for these chances so just went with
            column(HIGH_CHANCE, 240) // the common 100/240
        }


        row("dbrows.thieving_master_farmer") {
            column(XP, 43)
            column(LEVEL, 38)
            columnRSCM(DROPTABLE, "dbrows.thieving_master_farmer_drops")
            column(CATEGORY, 641)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 8)
            column(LOW_CHANCE, 90)
            column(HIGH_CHANCE, 240)
        }


        row("dbrows.thieving_guard") {
            column(XP, 46)
            column(LEVEL, 40)
            columnRSCM(DROPTABLE, "dbrows.thieving_guard_drops")
            column(CATEGORY, 470)
            column(STUN_DAMAGE_MIN, 1)
            column(STUN_DAMAGE_MAX, 2)
            column(STUN_DURATION, 8)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        // TODO: Add npcs to this, can't find any currently
        row("dbrows.thieving_fremennik_citizen") {
            column(XP, 65)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "dbrows.thieving_fremennik_citizen_drops")
            column(STUN_DAMAGE_MIN, 2)
            column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_desert_bandit") {
            column(XP, 79)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "dbrows.thieving_desert_bandit_drops")
            columnRSCM(NPCS, "npcs.fourdiamonds_sword_bandit_1", "npcs.fourdiamonds_sword_bandit_free")
            column(STUN_DAMAGE_MIN, 2)
			column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_knight_of_ardougne") {
            column(XP, 84)
            column(LEVEL, 55)
            columnRSCM(DROPTABLE, "dbrows.thieving_knight_of_ardougne_drops")
            column(CATEGORY, 1731)
            column(STUN_DAMAGE_MIN, 2)
			column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        // TODO: Add npcs to this, can't find any currently
        row("dbrows.thieving_knight_of_varlamore") {
            column(XP, 84)
            column(LEVEL, 55)
            column(CATEGORY, 1977)
            columnRSCM(DROPTABLE, "dbrows.thieving_knight_of_ardougne_drops")
            column(STUN_DAMAGE_MIN, 2)
			column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_yanille_watchman") {
            column(XP, 137)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "dbrows.thieving_yanille_watchman_drops")
            columnRSCM(NPCS, "npcs.yanille_watchman")
            column(STUN_DAMAGE_MIN, 2)
			column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_paladin") {
            column(XP, 131)
            column(LEVEL, 70)
            columnRSCM(DROPTABLE, "dbrows.thieving_paladin_drops")
            column(CATEGORY, 1729)
            column(STUN_DAMAGE_MIN, 2)
			column(STUN_DAMAGE_MAX, 3)
            column(STUN_DURATION, 9)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_gnome") {
            column(XP, 133)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "dbrows.thieving_gnome_drops")
            column(CATEGORY, 354)
            column(STUN_DAMAGE_MIN, 3)
			column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_hero") {
            column(XP, 163)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "dbrows.thieving_hero_drops")
            column(CATEGORY, 1730)
            column(STUN_DAMAGE_MIN, 3)
			column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_vyre") {
            column(XP, 306)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "dbrows.thieving_vyre_drops")
            column(CATEGORY, 1451)
            column(STUN_DAMAGE_MIN, 3)
			column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        row("dbrows.thieving_elf") {
            column(XP, 353)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "dbrows.thieving_elf_drops")
            column(CATEGORY, 1392)
            column(STUN_DAMAGE_MIN, 3)
			column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

        // TODO: Add npcs to this, unsure which to use
        row("dbrows.thieving_tzhaar") {
            column(XP, 103)
            column(LEVEL, 80)
            columnRSCM(DROPTABLE, "dbrows.thieving_tzhaar_drops")
            column(CATEGORY, 431)
            column(STUN_DAMAGE_MIN, 3)
			column(STUN_DAMAGE_MAX, 4)
            column(STUN_DURATION, 10)
            column(LOW_CHANCE, 180)
            column(HIGH_CHANCE, 240)
        }

    }
}
