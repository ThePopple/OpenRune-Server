package org.alter.impl.skills.thieving

import dev.openrune.definition.dbtables.DBTable
import dev.openrune.definition.dbtables.DBTableBuilder
import dev.openrune.definition.dbtables.dbTable
import dev.openrune.definition.util.VarType
import org.alter.impl.skills.thieving.Pickpocketing.WeightedItem

data class DropTableRow(
    val rowId: String,
    val drops: List<WeightedItem>
)

object ThievingDropTable {

    private const val ALWAYS = 0
    private const val COMMON = 256
    private const val UNCOMMON = 32
    private const val RARE = 8
    private const val VERY_RARE = 1


    fun createThievingDropTable(): DBTable {
        val rows = listOf(
            manDropTable(),
            farmerDropTable(),
            hamMemberDropTable(),
            warriorDropTable(),
            villagerDropTable(),
            rogueDropTable(),
            caveGoblinDropTable(),
            masterFarmerDropTable(),
            guardDropTable(),
            fremennikCitizenDropTable(),
            desertBanditDropTable(),
            knightOfArdougneDropTable(),
            yanilleWatchmanDropTable(),
            paladinDropTable(),
            gnomeDropTable(),
            heroDropTable(),
            vyreDropTable(),
            elfDropTable(),
            tzhaarDropTable(),
        )

        return dbTable("tables.thieving_droptable") {
            column("item", ITEM, VarType.OBJ)
            column("min_amount", MIN_AMOUNT, VarType.INT)
            column("max_amount", MAX_AMOUNT, VarType.INT)
            column("weight", WEIGHT, VarType.INT)

            rows.forEach { row ->
                row(row.rowId) {
                    val items = row.drops.map { it.item }.toTypedArray()
                    val min = row.drops.map { it.minAmount }.toTypedArray()
                    val max = row.drops.map { it.maxAmount }.toTypedArray()
                    val weight = row.drops.map { it.weight }.toTypedArray()

                    columnRSCM(ITEM, *items)
                    column(MIN_AMOUNT, *min)
                    column(MAX_AMOUNT, *max)
                    column(WEIGHT, *weight)
                }
            }
        }
    }

    fun manDropTable() = DropTableRow("dbrows.man_pickpocketing_droptable", listOf())

    fun farmerDropTable() = DropTableRow(
        "dbrows.farmer_pickpocketing_droptable", listOf(
            WeightedItem("items.potato_seed", 1, 1, RARE),
        )
    )

    fun hamMemberDropTable() = DropTableRow(
        "dbrows.ham_member_pickpocketing_droptable", listOf(
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

    fun warriorDropTable() = DropTableRow(
        "dbrows.warrior_pickpocketing_droptable", listOf()
    )

    fun villagerDropTable() = DropTableRow(
        "dbrows.villager_pickpocketing_droptable", listOf(
            WeightedItem("items.coins", 5, 5, ALWAYS),
        )
    )

    fun rogueDropTable() = DropTableRow(
        "dbrows.rogue_pickpocketing_droptable", listOf(
            WeightedItem("items.ring_of_dueling_1", 1, 1, RARE),
            WeightedItem("items.ring_of_dueling_2", 1, 1, RARE),
            WeightedItem("items.ring_of_dueling_3", 1, 1, RARE),
            WeightedItem("items.ring_of_dueling_4", 1, 1, RARE),
            WeightedItem("items.trail_clue_easy_simple001", 1, 1, VERY_RARE),
        )
    )

    fun caveGoblinDropTable() = DropTableRow(
        "dbrows.cave_goblin_pickpocketing_droptable", listOf(
            WeightedItem("items.airrune", 8, 8, COMMON),
            WeightedItem("items.lockpick", 1, 1, VERY_RARE),
            WeightedItem("items.jug_wine", 1, 1, UNCOMMON),
            WeightedItem("items.gold_bar", 1, 1, RARE),
            WeightedItem("items.iron_dagger_p", 1, 1, RARE),
        )
    )

    fun masterFarmerDropTable() = DropTableRow(
        "dbrows.master_farmer_pickpocketing_droptable", listOf(
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


    fun guardDropTable() = DropTableRow("dbrows.guard_pickpocketing_droptable", listOf())

    fun fremennikCitizenDropTable() = DropTableRow("dbrows.fremennik_citizen_pickpocketing_droptable", listOf())

    fun desertBanditDropTable() = DropTableRow("dbrows.desert_bandit_pickpocketing_droptable", listOf())

    fun knightOfArdougneDropTable() = DropTableRow("dbrows.knight_pickpocketing_droptable", listOf())

    fun yanilleWatchmanDropTable() = DropTableRow("dbrows.watchman_pickpocketing_droptable", listOf())

    fun paladinDropTable() = DropTableRow(
        "dbrows.paladin_pickpocketing_droptable", listOf(
            WeightedItem("items.chaosrune", 2, 2, COMMON),
        )
    )

    fun gnomeDropTable() = DropTableRow(
        "dbrows.gnome_pickpocketing_droptable", listOf(
            WeightedItem("items.earthrune", 1, 1, COMMON),
            WeightedItem("items.gold_ore", 1, 1, COMMON),
            WeightedItem("items.fire_orb", 1, 1, COMMON),
            WeightedItem("items.swamp_toad", 1, 1, COMMON),
            WeightedItem("items.king_worm", 1, 1, COMMON),
            WeightedItem("items.arrow_shaft", 1, 1, COMMON),
        )
    )

    fun heroDropTable() = DropTableRow(
        "dbrows.hero_pickpocketing_droptable", listOf(
            WeightedItem("items.deathrune", 2, 2, UNCOMMON),
            WeightedItem("items.bloodrune", 1, 1, UNCOMMON),
            WeightedItem("items.gold_ore", 1, 1, UNCOMMON),
            WeightedItem("items.jug_wine", 1, 1, UNCOMMON),
            WeightedItem("items.fire_orb", 1, 1, UNCOMMON),
            WeightedItem("items.diamond", 1, 1, UNCOMMON),
        )
    )

    fun vyreDropTable() = DropTableRow("dbrows.vyre_pickpocketing_droptable", listOf())

    fun elfDropTable() = DropTableRow("dbrows.elf_pickpocketing_droptable", listOf())

    fun tzhaarDropTable() = DropTableRow(
        "dbrows.tzhaar_pickpocketing_droptable", listOf(
            WeightedItem("items.tzhaar_token", 1, 16, COMMON),
            WeightedItem("items.uncut_sapphire", 1, 1, COMMON),
            WeightedItem("items.uncut_emerald", 1, 1, COMMON),
            WeightedItem("items.uncut_ruby", 1, 1, COMMON),
            WeightedItem("items.uncut_diamond", 1, 1, COMMON),
        )
    )

}