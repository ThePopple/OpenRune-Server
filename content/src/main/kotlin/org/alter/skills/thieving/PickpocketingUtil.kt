package org.alter.skills.thieving

import org.alter.game.model.entity.Player

val roguesOutfitPieces = listOf(
    "items.roguesden_helm",
    "items.roguesden_body",
    "items.roguesden_legs",
    "items.roguesden_boots",
    "items.roguesden_gloves"
)

fun Player.isWearingDodgyNecklace(): Boolean {
    return this.equipment.contains("items.dodgy_necklace")
}

fun Player.isWearingRogueOutfit(): Boolean {
    return roguesOutfitPieces.all {
        this.equipment.contains(it)
    }
}

fun Player.isWearingGlovesOfSilence(): Boolean {
    return this.equipment.contains("items.hunting_silent_gloves")
}

fun Player.isWearingThievingCape(): Boolean {
    return this.equipment.contains("items.skillcape_thieving") || this.equipment.contains("items.skillcape_thieving_trimmed")
}