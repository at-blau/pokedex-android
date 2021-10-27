package com.example.pokedex.infra.pokeapi.entity

import com.squareup.moshi.Json

data class Pokemon(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
//    val types: List<Type>,
//    val abilities: List<Ability>,
    @Json(name = "sprites") val sprite: Sprite
) {
    data class Type(
        val slot: Int,
        val name: String,
        val url: String
    )

    data class Ability(
        val slot: Int,
        val name: String,
        val isHidden: Boolean,
        val url: String
    )

    data class Sprite(
        @Json(name = "front_default") val frontDefault: String
    )
}
