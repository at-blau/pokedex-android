package com.example.pokedex.infra.pokeapi.entity

data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListElement>
)
