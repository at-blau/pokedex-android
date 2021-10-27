package com.example.pokedex.scene.pokemon_detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.infra.pokeapi.PokeApi
import com.example.pokedex.infra.pokeapi.entity.Pokemon
import kotlinx.coroutines.launch

class PokemonDetailViewModel(private val pokemonName: String): ViewModel() {
    val pokemon: LiveData<Pokemon>
        get() = _pokemon
    private val _pokemon = MutableLiveData<Pokemon>()

    fun onViewCreated() {
        viewModelScope.launch {
            PokeApi.retrofitService.getPokemon(pokemonName).body().let {
                _pokemon.postValue(it)
            }
        }
    }
}