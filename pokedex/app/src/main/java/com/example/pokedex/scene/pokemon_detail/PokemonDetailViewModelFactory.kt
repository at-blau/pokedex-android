package com.example.pokedex.scene.pokemon_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PokemonDetailViewModelFactory(private val pokemonName: String): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonDetailViewModel::class.java)) {
            return PokemonDetailViewModel(pokemonName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}